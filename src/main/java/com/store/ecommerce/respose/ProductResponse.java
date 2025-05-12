package com.store.ecommerce.respose;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ProductResponse {
    private String productName;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Integer categoryId;
    private Integer markForDelete;
    private String identifier;
    private String keyword;
}
