package com.olsonja.portfolio2.service;

import com.olsonja.portfolio2.model.Category;

import java.util.List;

public interface CategoryService {

    // Get all
    List<Category> getAllCategories();

    // Find by ID
    Category getCategoryById(Long id);

    // Create
    Category createCategory(Category category);

    // Update
    void updateCategory(Category category);

    // Delete
    void deleteCategory(Long id);

}
