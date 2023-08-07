package com.olsonja.portfolio2.service;

import com.olsonja.portfolio2.model.Project;

import java.util.List;

public interface ProjectService {

    // Get all
    List<Project> getAllProjects();

    // Get by ID
    Project getProjectById(Long id);

    // Create
    Project createProject(Project project);

    // Update
    void updateProject(Project project);

    // Delete
    void deleteProject(Long id);

}
