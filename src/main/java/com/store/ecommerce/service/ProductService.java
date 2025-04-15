package com.store.ecommerce.service;

import com.store.ecommerce.request.ProductRequest;
import com.store.ecommerce.respose.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {
    ProductResponse addProduct(ProductRequest productRequest);

    List<ProductResponse> getAllProducts();
}
