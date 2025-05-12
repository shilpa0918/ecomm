package com.store.ecommerce.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddProductRequest {
    private ProductRequest productRequest;
    private String categoryName;
    private List<AttributeForProductRequest> attributeForProductRequests;
    private List<String> imageUrls;
    private List<ProductPriceRequest> productPriceRequests;
    private List<ProductInventoryRequest> inventoryQuantity;

}
