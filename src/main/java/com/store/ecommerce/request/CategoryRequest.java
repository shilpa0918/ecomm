package com.store.ecommerce.request;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
public class CategoryRequest {
    private String categoryName;
    private String description;
    private Integer markForDelete;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String identifier;
    private String keyword;
    private List<Integer> productIds;
}
