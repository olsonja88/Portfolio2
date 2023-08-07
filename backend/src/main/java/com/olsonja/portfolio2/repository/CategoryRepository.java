package com.olsonja.portfolio2.repository;

import com.olsonja.portfolio2.model.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
