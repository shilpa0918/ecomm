package com.store.ecommerce.request;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;


public class CategoryRequest {
    private String categoryName;
    private String description;
    private Integer markForDelete;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String identifier;
    private String keyword;
    private List<Integer> productIds;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMarkForDelete() {
        return markForDelete;
    }

    public void setMarkForDelete(Integer markForDelete) {
        this.markForDelete = markForDelete;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public List<Integer> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<Integer> productIds) {
        this.productIds = productIds;
    }
}
