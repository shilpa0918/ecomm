package com.store.ecommerce.respose;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
public class CategoryResponse {
    private String categoryName;
    private String description;
    private Integer markForDelete;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String identifier;
    private String keyword;
    private List<Integer> productIds;
}
