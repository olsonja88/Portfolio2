package com.olsonja.portfolio2.model;

import jakarta.persistence.*;

@Entity
public class Project {

    // Instance Variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String link;


    // Constructors
    public Project() {
        this.name = name;
        this.description = description;
    }

    public Project(String name, String description, String link) {
        this.name = name;
        this.description = description;
        this.link = link;
    }


    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getLink() {
        return link;
    }


    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLink(String link) {
        this.link = link;
    }

}
