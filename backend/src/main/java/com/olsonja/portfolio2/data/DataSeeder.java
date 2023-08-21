package com.olsonja.portfolio2.data;

import com.olsonja.portfolio2.model.Project;
import com.olsonja.portfolio2.repository.ProjectRepository;
import java.util.Arrays;
import org.springframework.boot.CommandLineRunner;
// import org.springframework.stereotype.Component;

// @Component
public class DataSeeder implements CommandLineRunner {

    private final ProjectRepository projectRepository;

    public DataSeeder(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public void run(String... args) {
        if (projectRepository.count() == 0) {

            Project project1 = new Project("Johnolson.dev", "A Java Web Dev Project", "https://github.com/olsonja88/Portfolio2.git");
            Project project2 = new Project("Web Project 2", "A JavaScript Web Dev Project", "https://github.com/olsonja88/Spring-React-Blog.git");
            Project project3 = new Project("Discovery", "A Game Dev Project", "https://github.com/olsonja88/Discovery.git");

            projectRepository.saveAll(Arrays.asList(project1, project2, project3));

            projectRepository.findAll().forEach(System.out::println);
        }
    }
}
