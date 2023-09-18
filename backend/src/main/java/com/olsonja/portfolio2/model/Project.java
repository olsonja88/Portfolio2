package com.olsonja.portfolio2.model;

import jakarta.persistence.*;

@Entity
public class Project {

    // Instance Variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String briefSummary;
    private String description;
    private String link;
    @Lob
    private String base64Image;

    // Optional link
    private String link2;


    // Constructors
    public Project() {

    }


    public Project(String name, String briefSummary, String description, String link, String base64Image) {
        this.name = name;
        this.briefSummary = briefSummary;
        this.description = description;
        this.link = link;
        this.base64Image = base64Image;
    }


    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBriefSummary() {
        return briefSummary;
    }

    public String getDescription() {
        return description;
    }

    public String getLink() {
        return link;
    }

    public String getLink2() {
        return link2;
    }

    public String getBase64Image() {
        return base64Image;
    }


    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBriefSummary(String briefSummary) {
        this.briefSummary = briefSummary;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setLink2(String link2) {
        this.link2 = link2;
    }

    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }

}
