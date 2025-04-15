package com.store.ecommerce.service;

import com.store.ecommerce.entity.Category;
import com.store.ecommerce.request.CategoryRequest;
import com.store.ecommerce.respose.CategoryResponse;

import java.util.List;

public interface CategoryService {

    List<CategoryResponse> getAllCategories();

    Category findCategoryByid(Integer id);

    CategoryResponse addCategory(CategoryRequest categoryRequest);
}
