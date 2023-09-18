// This class is for locally data seeding the remote database

package com.olsonja.portfolio2.data;

import com.olsonja.portfolio2.model.Project;
import com.olsonja.portfolio2.repository.ProjectRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
//import java.io.InputStream;
//import java.nio.file.Files;
//import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Base64;


@Component
public class DataSeeder implements CommandLineRunner {

    private final ProjectRepository projectRepository;
    private final ResourceLoader resourceLoader;

    // Create an instance of Logger for this class
    private static final Logger logger = Logger.getLogger(DataSeeder.class);


    // Constructor
    public DataSeeder(ProjectRepository projectRepository, ResourceLoader resourceLoader) {
        this.projectRepository = projectRepository;
        this.resourceLoader = resourceLoader;
    }


    // For converting any local image file to a byte array
    public byte[] convertImageToByteArray(Resource imageResource) {

        try {
            return IOUtils.toByteArray(imageResource.getInputStream()); // Convert the bytes from the InputStream into a Byte array
        } catch (IOException e) {
            System.out.println("*** AN EXCEPTION HAS OCCURRED ***:" + e);
            logger.error("An exception has occurred: " + e);
            return null;
        }
    }


    public void run(String... args) {

        if (projectRepository.count() == 0) {

            // Populate DB with projects
            try {
                Resource imageResource = resourceLoader.getResource("classpath:data/images/project1.jpg");

                // Convert our image files to byte arrays
                byte[] image1 = convertImageToByteArray(imageResource);

                if (image1 == null) {
                    System.out.println("*** ONE OR MORE OF THE IMAGES PROVIDED IS NULL UPON BYTE ARRAY CONVERSION. ***");
                    logger.error("*** ONE OR MORE OF THE IMAGES PROVIDED IS NULL UPON BYTE ARRAY CONVERSION. ***");
                } else {
                    // Convert image byte arrays to base64Images
                    String base64Image1 = Base64.getEncoder().encodeToString(image1);

                    // Create sample projects
                    Project project1 = new Project("Johnolson.dev", "A Java Web Dev Project", "A personal portfolio website made using a Spring Boot API, React frontend, and PostgreSQL remote database.","https://github.com/olsonja88/Portfolio2.git", base64Image1);

                    // Save projects to the repository
                    projectRepository.saveAll(Arrays.asList(project1));

                    // Print projects to the console
                    projectRepository.findAll().forEach(System.out::println);
                }

            } catch (Exception e) {
                System.out.println("*** AN EXCEPTION HAS OCCURRED ***:" + e);
                logger.error("An exception has occurred: " + e);
            }
        }
    }
}
