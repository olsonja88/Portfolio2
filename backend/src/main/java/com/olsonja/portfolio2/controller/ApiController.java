package com.olsonja.portfolio2.controller;

import com.olsonja.portfolio2.service.ProjectService;
import com.olsonja.portfolio2.model.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"*"})
public class ApiController {

    // Instance Variables
    private final ProjectService projectService;


    // Constructor
    @Autowired
    public ApiController(ProjectService projectService) {
        this.projectService = projectService;
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
