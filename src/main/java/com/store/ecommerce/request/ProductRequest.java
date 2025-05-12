package com.store.ecommerce.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class ProductRequest {
    private String productName;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Integer categoryId;
    private Integer markForDelete;
    private String identifier;
    private String keyword;
}
