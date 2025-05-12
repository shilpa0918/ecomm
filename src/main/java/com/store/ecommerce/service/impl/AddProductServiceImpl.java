package com.store.ecommerce.service.impl;

import com.store.ecommerce.entity.*;
import com.store.ecommerce.repo.*;
import com.store.ecommerce.request.*;
import com.store.ecommerce.respose.*;
import com.store.ecommerce.service.AddProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class AddProductServiceImpl implements AddProductService {

    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private AttributeValueRepo attributeValueRepo;
    @Autowired
    private AttributeRepo attributeRepo;
    @Autowired
    private ImageRepo imageRepo;
    @Autowired
    private PriceRepo priceRepo;
    @Autowired
    private InventoryRepo inventoryRepo;

    @Override
    public PdpProductResponse pdpAddProduct(AddProductRequest productRequest) {
        PdpProductResponse productResponse = new PdpProductResponse();
        //Product Entity
        Product product = new Product();
        product.setProductName(productRequest.getProductRequest().getProductName());
        product.setDescription(productRequest.getProductRequest().getDescription());
        product.setUpdatedAt(productRequest.getProductRequest().getUpdatedAt());
        product.setCreatedAt(productRequest.getProductRequest().getCreatedAt());
        product.setIdentifier(productRequest.getProductRequest().getIdentifier());
        product.setKeyword(productRequest.getProductRequest().getKeyword());
        product.setMarkForDelete(productRequest.getProductRequest().getMarkForDelete());
        //Category Entity
        Category category = categoryRepo.findByCategoryName(productRequest.getCategoryName());
        product.setCategory(category);
        //Attribute & AttributeValues
        List<Attribute> attributes = productRequest.getAttributeForProductRequests().stream()
                .map(attr -> {
                    Attribute attribute = attributeRepo.findByAttrName(attr.getAttrName());
                    attribute.setProduct(product);
                    List<String> attributeValues = attr.getAttrValues();
                    List<AttributeValue> attrValuesData = new ArrayList<>();
                    attributeValues.stream().map(attrValue -> {
                        return attributeValueRepo.findByAttrValue(attrValue);
                    }).toList();
                    attribute.setAttributeValues(attrValuesData);
                    return attribute;
                }).toList();
        product.setAttributes(attributes);
        //Image
        List<Image> images = productRequest.getImageUrls().stream().map(imageData -> {
            Image image = new Image();
            image.setProduct(product);
            image.setImageUrl(imageData);
            image.setUpdatedAt(LocalDateTime.now());
            image.setCreatedAt(LocalDateTime.now());
            return image;
        }).toList();
        System.out.println(images);
        product.setImage(images);
        //Inventory
        List<Inventory> inventoryQuantity = productRequest.getInventoryQuantity().stream().map(inventory -> {
            Inventory quantity = new Inventory();
            quantity.setQuantity(inventory.getQuantity());
            quantity.setStoreId(inventory.getStoreId());
            quantity.setUpdatedAt(LocalDateTime.now());
            quantity.setCreatedAt(LocalDateTime.now());
            quantity.setProduct(product);
            return quantity;
        }).toList();
        product.setInventories(inventoryQuantity);

        //Price
        List<Price> prices = productRequest.getProductPriceRequests().stream().map(productPriceRequest -> {
            Price price = new Price();
            price.setPriceType(productPriceRequest.getPriceType());
            price.setPrice(productPriceRequest.getPrice());
            price.setUpdatedAt(LocalDateTime.now());
            price.setCreatedAt(LocalDateTime.now());
            price.setProduct(product);
            return price;
        }).toList();
        product.setPrice(prices);
        //SaveProduct
        Product savedProduct = productRepo.saveAndFlush(product);

        return convertedIntoProductDto(savedProduct);
    }

    private PdpProductResponse convertedIntoProductDto(Product savedProduct) {
        PdpProductResponse productResponse = new PdpProductResponse();
        ProductRequest productRequest = getProductRequest(savedProduct);
        productResponse.setProductRequest(productRequest);
        productResponse.setCategoryName(savedProduct.getCategory().getCategoryName());
        List<String> images = savedProduct.getImage().stream().map(Image::getImageUrl).toList();
        productResponse.setImageUrls(images);

        List<ProductInventoryRequest> quantities = new ArrayList<>();
        List<Inventory> inventories = savedProduct.getInventories();
        inventories.stream().map(inventory -> {
            ProductInventoryRequest productInventoryRequest = new ProductInventoryRequest();
            productInventoryRequest.setQuantity(inventory.getQuantity());
            productInventoryRequest.setStoreId(inventory.getStoreId());
            return quantities.add(productInventoryRequest);
        }).toList();
        productResponse.setInventoryQuantity(quantities);

        List<ProductPriceRequest> productPriceRequests = new ArrayList<>();
        List<Price> prices = savedProduct.getPrice();
        prices.stream().map(price -> {
            ProductPriceRequest productPriceRequest = new ProductPriceRequest();
            productPriceRequest.setPriceType(price.getPriceType());
            productPriceRequest.setPrice(price.getPrice());
            return productPriceRequests.add(productPriceRequest);
        }).toList();
        productResponse.setProductPriceRequests(productPriceRequests);

        List<AttributeForProductRequest> attributeForProductRequests = new ArrayList<>();
        //add attribute & attributeValue
        List<Attribute> attributes = savedProduct.getAttributes();
        attributes.stream().map(attr -> {
            AttributeForProductRequest attribute = new AttributeForProductRequest();
            attribute.setAttrName(attr.getAttrName());
            List<AttributeValue> attrValues = attr.getAttributeValues();
            List<String> attrValuesData = attrValues.stream().map(AttributeValue::getAttrValue).toList();
            attribute.setAttrValues(attrValuesData);
            return attribute;
        }).toList();
        productResponse.setAttributeForProductRequests(attributeForProductRequests);
        return productResponse;
    }

    private static ProductRequest getProductRequest(Product savedProduct) {
        ProductRequest productRequest = new ProductRequest();
        productRequest.setProductName(savedProduct.getProductName());
        productRequest.setDescription(savedProduct.getDescription());
        productRequest.setUpdatedAt(savedProduct.getUpdatedAt());
        productRequest.setCreatedAt(savedProduct.getCreatedAt());
        productRequest.setIdentifier(savedProduct.getIdentifier());
        productRequest.setKeyword(savedProduct.getKeyword());
        productRequest.setMarkForDelete(savedProduct.getMarkForDelete());
        return productRequest;
    }

    @Override
    public PdpProductResponse updateProduct(AddProductRequest updatePdpProductRequest, String productName) {
        Product product = productRepo.findByProductName(productName);
        product.setProductName(updatePdpProductRequest.getProductRequest().getProductName());
        product.setDescription(updatePdpProductRequest.getProductRequest().getDescription());
        product.setUpdatedAt(updatePdpProductRequest.getProductRequest().getUpdatedAt());
        product.setCreatedAt(updatePdpProductRequest.getProductRequest().getCreatedAt());
        product.setIdentifier(updatePdpProductRequest.getProductRequest().getIdentifier());
        product.setKeyword(updatePdpProductRequest.getProductRequest().getKeyword());
        product.setMarkForDelete(updatePdpProductRequest.getProductRequest().getMarkForDelete());

        List<Image> images = product.getImage(); //existing images in product from DB
        List<Image> imagesToUpdate = updatePdpProductRequest.getImageUrls().stream().map(imageStr -> {
            Image image = new Image();
            image.setImageUrl(imageStr);
            image.setUpdatedAt(LocalDateTime.now());
            image.setProduct(product);
            return image;
        }).toList(); // new images that i build using image String in the request
        images.addAll(imagesToUpdate);
        System.out.println(images);
        product.setImage(images);
        //Inventory
        List<Inventory> inventories = product.getInventories();
        List<Inventory> inventoryQuantity = updatePdpProductRequest.getInventoryQuantity().stream()
                .map(inventory -> {
                    Inventory quantity = new Inventory();
                    quantity.setQuantity(inventory.getQuantity());
                    quantity.setStoreId(inventory.getStoreId());
                    quantity.setUpdatedAt(LocalDateTime.now());
                    quantity.setProduct(product);
                    return quantity;
                }).toList();
        inventories.addAll(inventoryQuantity);
        product.setInventories(inventories);
        //Price
        List<Price> priceList = product.getPrice();
        List<Price> prices = updatePdpProductRequest.getProductPriceRequests().stream()
                .map(productPriceRequest -> {
                    Price price = new Price();
                    price.setPriceType(productPriceRequest.getPriceType());
                    price.setPrice(productPriceRequest.getPrice());
                    price.setUpdatedAt(LocalDateTime.now());
                    price.setProduct(product);
                    return price;
                }).toList();
        priceList.addAll(prices);
        product.setPrice(priceList);
        //Attribute
       /* AtomicReference<List<AttributeValue>> attributeValues = new AtomicReference<>();
        List<Attribute> attributes = product.getAttributes();
        attributes.stream().map(attribute -> {
            AttributeValue attributeValue = new AttributeValue();
            attributeValues.set(attribute.getAttributeValues());
            return null;
        }).toList();
       // List<AttributeValue> attributeValueList = new ArrayList<>();
        List<Attribute> attributeList = updatePdpProductRequest.getAttributeForProductRequests().stream()
            .map(attributeForProductRequest -> {
                Attribute attribute = new Attribute();
                attribute.setAttrName(attributeForProductRequest.getAttrName());
                attributeForProductRequest.getAttrValues().stream().map(s -> {
                    AttributeValue attributeValue = new AttributeValue();
                    attributeValue.setAttrValue(s);
                   // attributeValueList.add(attributeValue);
                    attribute.setAttributeValues(attributeValue.getAttribute().getAttributeValues());
                }).toList();
               return null;
            }).toList();

        product.setAttributes(attributeList);*/
        //SaveProduct
        Product updatedProduct = productRepo.saveAndFlush(product);
        return convertedIntoProductDto(updatedProduct);
    }

}
