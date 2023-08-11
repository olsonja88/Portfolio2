package com.olsonja.portfolio2.service;

import com.olsonja.portfolio2.model.Post;
import com.olsonja.portfolio2.model.Category;

import java.util.List;

public interface PostService {

    // Get all
    List<Post> getAllPosts();

    // Get by ID
    Post getPostById(Long id);

    // Create
    Post createPost(Post post, Category category);

    // Update
    void updatePost(Post post);

    // Delete
    void deletePost(Long id);

}
