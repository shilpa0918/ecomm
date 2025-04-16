package com.store.ecommerce.respose;

import com.store.ecommerce.entity.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ProductResponse {
    private String productName;
    private String description;
    private int stock;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Integer categoryId;
    private List<Attribute> attributes;
    private Integer markForDelete;
    private String identifier;
    private String keyword;
}
