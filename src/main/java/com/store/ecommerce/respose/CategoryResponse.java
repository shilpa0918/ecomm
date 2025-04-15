package com.store.ecommerce.respose;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;


public class CategoryResponse {
    private String categoryName;
    private String description;
    private Integer markForDelete;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String identifier;
    private String keyword;
    private List<Integer> productIds;

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMarkForDelete(Integer markForDelete) {
        this.markForDelete = markForDelete;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void setProductIds(List<Integer> productIds) {
        this.productIds = productIds;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getDescription() {
        return description;
    }

    public Integer getMarkForDelete() {
        return markForDelete;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getKeyword() {
        return keyword;
    }

    public List<Integer> getProductIds() {
        return productIds;
    }
}
