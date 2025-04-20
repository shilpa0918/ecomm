package com.store.ecommerce.service;

import com.store.ecommerce.request.ProductRequest;
import com.store.ecommerce.respose.ProductResponse;

import java.util.List;

public interface ProductService {
    ProductResponse addProduct(ProductRequest productRequest);

    List<ProductResponse> getAllProducts();

    ProductResponse getProductByName(String productName);

    List<ProductResponse> getProductsByCategory(String categoryName);
}
