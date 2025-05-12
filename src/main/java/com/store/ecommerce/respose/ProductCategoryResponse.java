package com.store.ecommerce.respose;

import com.store.ecommerce.request.AttributeForProductRequest;
import com.store.ecommerce.request.ProductInventoryRequest;
import com.store.ecommerce.request.ProductPriceRequest;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ProductCategoryResponse {
    private String productName;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Integer categoryId;
    private Integer markForDelete;
    private String identifier;
    private String keyword;
    private List<String> imageUrls;
    private List<ProductInventoryRequest> inventoryQuantity;
    private List<ProductPriceRequest> productPriceRequests;
    private List<AttributeForProductRequest> attributeForProductRequests;
}
