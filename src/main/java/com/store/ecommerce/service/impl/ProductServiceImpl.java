package com.store.ecommerce.service.impl;

import com.store.ecommerce.entity.Category;
import com.store.ecommerce.entity.Product;
import com.store.ecommerce.repo.CategoryRepo;
import com.store.ecommerce.repo.ProductRepo;
import com.store.ecommerce.request.ProductRequest;
import com.store.ecommerce.respose.ProductResponse;
import com.store.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
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
        Category category = categoryRepo.findById(productRequest.getCategoryId()).get();
        product.setCategory(category);
        product.setListPrice(productRequest.getListPrice());
        product.setOfferPrice(productRequest.getOfferPrice());
        product.setImageUrl(productRequest.getImageUrl());
        product.setUpdatedAt(productRequest.getUpdatedAt());
        product.setStock(productRequest.getStock());
        Product addedProduct = productRepo.saveAndFlush(product);
        return convertedToProductDto(addedProduct);
    }


    private ProductResponse convertedToProductDto(Product addedProduct) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setProductName(addedProduct.getProductName());
        productResponse.setDescription(addedProduct.getDescription());
        productResponse.setCreatedAt(addedProduct.getCreatedAt());
        productResponse.setCategoryId(addedProduct.getCategory().getId());
        productResponse.setListPrice(addedProduct.getListPrice());
        productResponse.setOfferPrice(addedProduct.getOfferPrice());
        productResponse.setUpdatedAt(addedProduct.getUpdatedAt());
        productResponse.setImageUrl(addedProduct.getImageUrl());
        productResponse.setStock(addedProduct.getStock());
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
}
