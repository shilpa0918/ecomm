package com.store.ecommerce.respose;

import com.store.ecommerce.request.AttributeForProductRequest;
import com.store.ecommerce.request.ProductInventoryRequest;
import com.store.ecommerce.request.ProductPriceRequest;
import com.store.ecommerce.request.ProductRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PdpProductResponse {
    private ProductRequest productRequest;
    private String categoryName;
    private List<AttributeForProductRequest> attributeForProductRequests;
    private List<String> imageUrls;
    private List<ProductPriceRequest> productPriceRequests;
    private List<ProductInventoryRequest> inventoryQuantity;

}
