package com.olsonja.portfolio2.controller;

import com.olsonja.portfolio2.service.CategoryService;
import com.olsonja.portfolio2.service.PostService;
import com.olsonja.portfolio2.service.ProjectService;
import com.olsonja.portfolio2.model.Category;
import com.olsonja.portfolio2.model.Post;
import com.olsonja.portfolio2.model.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    // Instance Variables
    private final CategoryService categoryService;
    private final PostService postService;
    private final ProjectService projectService;


    // Constructor
    @Autowired
    public ApiController(CategoryService categoryService, PostService postService, ProjectService projectService) {
        this.categoryService = categoryService;
        this.postService = postService;
        this.projectService = projectService;
    }


    // Handle methods for categories
    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/categories/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    @PostMapping("/categories")
    public Category createCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    @PutMapping("/categories/{id}")
    public void updateCategory(@PathVariable Long id, @RequestBody Category category) {
        category.setId(id);
        categoryService.updateCategory(category);
    }

    @DeleteMapping("/categories/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }


    // Handle methods for posts
    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/posts/{id}")
    public Post getPostById(@PathVariable Long id) {
        return postService.getPostById(id);
    }

    @PostMapping("/posts")
    public Post createPost(@RequestBody Post post, Category category) {
        return postService.createPost(post, category);
    }

    @PutMapping("/posts/{id}")
    public void updatePost(@PathVariable Long id, @RequestBody Post post) {
        post.setId(id);
        postService.updatePost(post);
    }

    @DeleteMapping("/posts/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }


    // Handle methods for projects
    @GetMapping("/projects")
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/projects/{id}")
    public Project getProjectById(@PathVariable Long id) {
        return projectService.getProjectById(id);
    }

    @PostMapping("/project")
    public Project createProject(@RequestBody Project project) {
        return projectService.createProject(project);
    }

    @PutMapping("/projects/{id}")
    public void updateProject(@PathVariable Long id, @RequestBody Project project) {
        project.setId(id);
        projectService.updateProject(project);
    }

    @DeleteMapping("/projects/{id}")
    public void deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
    }

}
