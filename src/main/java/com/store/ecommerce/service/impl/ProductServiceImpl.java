package com.store.ecommerce.service.impl;

import com.store.ecommerce.entity.*;
import com.store.ecommerce.repo.CategoryRepo;
import com.store.ecommerce.repo.ProductRepo;
import com.store.ecommerce.request.AttributeForProductRequest;
import com.store.ecommerce.request.ProductInventoryRequest;
import com.store.ecommerce.request.ProductPriceRequest;
import com.store.ecommerce.request.ProductRequest;
import com.store.ecommerce.respose.ProductCategoryResponse;
import com.store.ecommerce.respose.ProductResponse;
import com.store.ecommerce.service.ProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Attr;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService {

    @Autowired
    CategoryRepo categoryRepo;
    @Autowired
    ProductRepo productRepo;

    @Override
    public ProductResponse addProduct(ProductRequest productRequest) {
        Product product = new Product();
        product.setProductName(productRequest.getProductName());
        product.setDescription(productRequest.getDescription());
        product.setCreatedAt(productRequest.getCreatedAt());
        Category category = categoryRepo.findById(productRequest.getCategoryId()).
                get();
        product.setCategory(category);
        product.setUpdatedAt(productRequest.getUpdatedAt());
        product.setMarkForDelete(productRequest.getMarkForDelete());
        product.setKeyword(productRequest.getKeyword());
        product.setIdentifier(productRequest.getIdentifier());
        Product addedProduct = productRepo.saveAndFlush(product);
        return convertedToProductDto(addedProduct);
    }


    private ProductResponse convertedToProductDto(Product addedProduct) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setProductName(addedProduct.getProductName());
        productResponse.setDescription(addedProduct.getDescription());
        productResponse.setCreatedAt(addedProduct.getCreatedAt());
        productResponse.setCategoryId(addedProduct.getCategory().getId());
        productResponse.setUpdatedAt(addedProduct.getUpdatedAt());
        productResponse.setMarkForDelete(addedProduct.getMarkForDelete());
        productResponse.setKeyword(addedProduct.getKeyword());
        productResponse.setIdentifier(addedProduct.getIdentifier());
        return productResponse;
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepo.findAll();
        return products.stream().map(this::convertedToProductDto).collect(Collectors.toList());
    }

    @Override
    public ProductResponse getProductByName(String productName) {
        Product product = productRepo.findByProductName(productName);
        return convertedToProductDto(product);
    }

    @Override
    public List<ProductCategoryResponse> getProductsByCategory(String categoryName) {
        List<Product> products = productRepo.findByCategoryCategoryName(categoryName);
        List<ProductCategoryResponse> productCategoryResponses = new ArrayList<>();
        products.stream().map(product -> {
            ProductCategoryResponse productCategoryResponse = new ProductCategoryResponse();
            productCategoryResponse.setProductName(product.getProductName());
            productCategoryResponse.setDescription(product.getDescription());
            productCategoryResponse.setCreatedAt(product.getCreatedAt());
            productCategoryResponse.setCategoryId(product.getCategory().getId());
            productCategoryResponse.setUpdatedAt(product.getUpdatedAt());
            productCategoryResponse.setMarkForDelete(product.getMarkForDelete());
            productCategoryResponse.setKeyword(product.getKeyword());
            productCategoryResponse.setIdentifier(product.getIdentifier());
            //setImages
            List<Image> images = product.getImage();
            List<String> productImages = images.stream().map(image -> {
                return image.getImageUrl();
            }).toList();
            productCategoryResponse.setImageUrls(productImages);
            //setPrice
            List<Price> prices = product.getPrice();
            List<ProductPriceRequest> productPriceRequests = new ArrayList<>();
            prices.stream().map(price -> {
                ProductPriceRequest productPriceRequest = new ProductPriceRequest();
                productPriceRequest.setPrice(price.getPrice());
                productPriceRequest.setPriceType(price.getPriceType());
                return productPriceRequests.add(productPriceRequest);
            }).toList();
            productCategoryResponse.setProductPriceRequests(productPriceRequests);
            //setInventory
            List<Inventory> inventories = product.getInventories();
            List<ProductInventoryRequest> productInventoryRequests = new ArrayList<>();
            inventories.stream().map(inventory -> {
                ProductInventoryRequest productInventoryRequest = new ProductInventoryRequest();
                productInventoryRequest.setStoreId(inventory.getStoreId());
                productInventoryRequest.setQuantity(inventory.getQuantity());
                return productInventoryRequests.add(productInventoryRequest);
            }).toList();
            productCategoryResponse.setInventoryQuantity(productInventoryRequests);
            //setAttribute and attributeValue
            List<AttributeForProductRequest> attributeForProductRequests = new ArrayList<>();
            List<Attribute> attributes = product.getAttributes();
            attributes.stream().map(attribute -> {
                AttributeForProductRequest attributeData = new AttributeForProductRequest();
                attributeData.setAttrName(attribute.getAttrName());
                List<AttributeValue> attributeValues = attribute.getAttributeValues();
                List<String> attrValueList = new ArrayList<>();
                attributeValues.stream().map(attributeValue -> {
                    String attributeValueData = attributeValue.getAttrValue();
                    return attrValueList.add(attributeValueData);
                }).toList();
                attributeData.setAttrValues(attrValueList);
                return attributeForProductRequests.add(attributeData);
            }).toList();
            productCategoryResponse.setAttributeForProductRequests(attributeForProductRequests);
            return productCategoryResponses.add(productCategoryResponse);
        }).toList();
        return productCategoryResponses;
    }

    public ProductResponse updateProductById(Integer productId, ProductRequest productRequest) {
        Product updatedProduct = productRepo.findById(productId).get();
        updatedProduct.setUpdatedAt(productRequest.getUpdatedAt());
        updatedProduct.setDescription(productRequest.getDescription());
        updatedProduct.setProductName(productRequest.getProductName());
        updatedProduct.setMarkForDelete(productRequest.getMarkForDelete());
        updatedProduct.setKeyword(productRequest.getKeyword());
        updatedProduct.setIdentifier(productRequest.getIdentifier());
        Product savedUpdatedProduct = productRepo.saveAndFlush(updatedProduct);
        return convertedToProductDto(savedUpdatedProduct);
    }

    @Override
    public List<ProductResponse> addProducts(List<ProductRequest> productRequests) {
        log.info(System.currentTimeMillis() / 60);
        List<Product> productList = productRequests.stream().map(productRequest -> {
            Product product = new Product();
            product.setProductName(productRequest.getProductName());
            product.setDescription(productRequest.getDescription());
            product.setCreatedAt(productRequest.getCreatedAt());
            Category category = categoryRepo.findById(productRequest.getCategoryId()).get();
            product.setCategory(category);
            product.setUpdatedAt(productRequest.getUpdatedAt());
            product.setMarkForDelete(productRequest.getMarkForDelete());
            product.setKeyword(productRequest.getKeyword());
            product.setIdentifier(productRequest.getIdentifier());
            return productRepo.saveAndFlush(product);
        }).toList();
        log.info(System.currentTimeMillis() / 60);
        return productList.stream().map(this::convertedToProductDto).toList();
    }

    @Override
    public List<ProductResponse> addProductList(List<ProductRequest> productRequests) {
        List<Product> productList = productRequests.stream().map(productRequest -> {
            Product product = new Product();
            log.info(System.currentTimeMillis() / 60);
            product.setProductName(productRequest.getProductName());
            product.setDescription(productRequest.getDescription());
            product.setCreatedAt(productRequest.getCreatedAt());
            Category category = categoryRepo.findById(productRequest.getCategoryId()).get();
            product.setCategory(category);
            product.setUpdatedAt(productRequest.getUpdatedAt());
            product.setMarkForDelete(productRequest.getMarkForDelete());
            product.setKeyword(productRequest.getKeyword());
            product.setIdentifier(productRequest.getIdentifier());
            return product;
        }).toList();
        List<Product> savedProductData = productRepo.saveAllAndFlush(productList);
        log.info(System.currentTimeMillis() / 60);
        return savedProductData.stream().map(this::convertedToProductDto).toList();
    }

    @Override
    public void deleteProduct(Integer productId) {
        productRepo.deleteById(productId);
    }
}
