package com.store.ecommerce.request;

import com.store.ecommerce.entity.Attribute;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
public class ProductRequest {
    private String productName;
    private String description;
    private int stock;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Integer categoryId;
    private Integer markForDelete;
    private String identifier;
    private String keyword;
}
