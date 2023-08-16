package com.olsonja.portfolio2.model;

import jakarta.persistence.*;

@Entity
public class Post {

    // Instance Variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;


    // Constructors
    public Post() {
        this.name = name;
        this.content = content;
    }

    public Post(String name, String content, Category category) {
        this.name = name;
        this.content = content;
        this.category = category;
    }


    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public Category getCategory() {
        return category;
    }


    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
