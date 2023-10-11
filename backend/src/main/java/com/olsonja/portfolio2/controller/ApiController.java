package com.olsonja.portfolio2.controller;

import com.olsonja.portfolio2.service.ProjectService;
import com.olsonja.portfolio2.model.Project;
import com.olsonja.portfolio2.service.EmailService;
import com.olsonja.portfolio2.model.EmailRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api")
// @CrossOrigin(origins = {"https://portfolio2-ten-kohl.vercel.app", "https://johnolson.dev"})
@CrossOrigin(origins = "*")
public class ApiController {

    // Instance Variables
    private final ProjectService projectService;
    private EmailService emailService;

    // Constructor
    @Autowired
    public ApiController(ProjectService projectService) {
        this.projectService = projectService;
        //this.emailService = emailService;
    }


    // Handle requests for projects
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


    // Handle requests for Emails
//    @PostMapping("/send-email")
//    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest emailRequest) {
//
//        emailService.sendEmail(emailRequest);
//
//        return ResponseEntity.ok("Email sent successfully");
//    }

}
