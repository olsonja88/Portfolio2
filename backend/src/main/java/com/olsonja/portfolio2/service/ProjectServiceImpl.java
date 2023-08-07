package com.olsonja.portfolio2.service;

import com.olsonja.portfolio2.repository.ProjectRepository;
import com.olsonja.portfolio2.model.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    // Instance Variables
    private final ProjectRepository projectRepository;


    // Constructor
    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }


    // Get all
    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }


    // Get by ID
    @Override
    public Project getProjectById(Long id) {
        return projectRepository.findById(id).orElse(null);
    }


    // Create
    @Override
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }


    // Update
    @Override
    public void updateProject(Project project) {
        projectRepository.save(project);
    }


    // Delete
    @Override
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }

}
