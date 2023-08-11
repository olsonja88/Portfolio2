package com.olsonja.portfolio2.service;

import com.olsonja.portfolio2.repository.CategoryRepository;
import com.olsonja.portfolio2.model.Category;
import com.olsonja.portfolio2.repository.PostRepository;
import com.olsonja.portfolio2.model.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    // Instance Variables
    private final PostRepository postRepository;


    // Constructor
    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    // Get all
    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }


    // Get by ID
    public Post getPostById(Long id) {
        return postRepository.findById(id).orElse(null);
    }


    // Create
    public Post createPost(Post post, Category category) {
        // Set new post to the desired category
        post.setCategory(category);

        // Save new post
        return postRepository.save(post);
    }


    // Update
    public void updatePost(Post post) {
        postRepository.save(post);
    }


    // Delete
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

}
