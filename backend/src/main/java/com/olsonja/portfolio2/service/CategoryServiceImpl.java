package com.olsonja.portfolio2.service;

import com.olsonja.portfolio2.repository.CategoryRepository;
import com.olsonja.portfolio2.model.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    // Instance variables
    private final CategoryRepository categoryRepository;


    // Constructor
    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    // Get all
    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }


    // Find by ID
    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }


    // Create
    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }


    // Update
    @Override
    public void updateCategory(Category category) {
        categoryRepository.save(category);
    }


    // Delete
    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

}
