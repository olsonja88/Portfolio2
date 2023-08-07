package com.olsonja.portfolio2.repository;

import com.olsonja.portfolio2.model.Post;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
