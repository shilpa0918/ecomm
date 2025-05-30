package com.store.ecommerce.service;

import com.store.ecommerce.request.AddProductRequest;
import com.store.ecommerce.respose.PdpProductResponse;

import java.util.List;

public interface AddProductService {
    PdpProductResponse pdpAddProduct(AddProductRequest productRequest);

    PdpProductResponse updateProduct(AddProductRequest productRequest, String productName);

    List<PdpProductResponse> getProductsByAttribute(String attributeName, String attributeValue);
}
