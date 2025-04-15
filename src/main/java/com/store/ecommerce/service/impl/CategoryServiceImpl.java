package com.store.ecommerce.service.impl;

import com.store.ecommerce.entity.Category;
import com.store.ecommerce.repo.CategoryRepo;
import com.store.ecommerce.request.CategoryRequest;
import com.store.ecommerce.respose.CategoryResponse;
import com.store.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepo categoryRepo;

    @Override
    public List<CategoryResponse> getAllCategories() {
        List<Category> categories = categoryRepo.findAll();
        return categories.stream().map(this::getCategoryResponse).collect(Collectors.toList());
    }

    @Override
    public Category findCategoryByid(Integer id) {
        return categoryRepo.findById(id).get();
    }

    @Override
    public CategoryResponse addCategory(CategoryRequest categoryRequest) {
        Category category = new Category();
        category.setCategoryName(categoryRequest.getCategoryName());
        category.setDescription(categoryRequest.getDescription());
        category.setKeyword(categoryRequest.getKeyword());
        category.setMarkForDelete(categoryRequest.getMarkForDelete());
        category.setIdentifier(categoryRequest.getIdentifier());
        category.setCreatedAt(categoryRequest.getCreatedAt());
        category.setUpdatedAt(categoryRequest.getUpdatedAt());
        Category savedCategory = categoryRepo.saveAndFlush(category);
        return convertedToCategoryDto(savedCategory);
    }

    private CategoryResponse convertedToCategoryDto(Category savedCategory) {
        return getCategoryResponse(savedCategory);
    }

    private CategoryResponse getCategoryResponse(Category savedCategory) {
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setCategoryName(savedCategory.getCategoryName());
        categoryResponse.setDescription(savedCategory.getDescription());
        categoryResponse.setKeyword(savedCategory.getKeyword());
        categoryResponse.setMarkForDelete(savedCategory.getMarkForDelete());
        categoryResponse.setIdentifier(savedCategory.getIdentifier());
        categoryResponse.setCreatedAt(savedCategory.getCreatedAt());
        categoryResponse.setUpdatedAt(savedCategory.getUpdatedAt());
        return categoryResponse;
    }
}
