package com.store.ecommerce.service;

import com.store.ecommerce.request.ProductRequest;
import com.store.ecommerce.respose.ProductCategoryResponse;
import com.store.ecommerce.respose.ProductResponse;

import java.util.List;

public interface ProductService {
    ProductResponse addProduct(ProductRequest productRequest);

    List<ProductResponse> getAllProducts();

    ProductResponse getProductByName(String productName);

    List<ProductCategoryResponse> getProductsByCategory(String categoryName);

    ProductResponse updateProductById(Integer productId, ProductRequest productRequest);

    List<ProductResponse> addProducts(List<ProductRequest> productRequests);

    List<ProductResponse> addProductList(List<ProductRequest> productRequests);

    void deleteProduct(Integer productId);
}
