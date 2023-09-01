// This class is for locally data seeding the remote database for testing purposes

package com.olsonja.portfolio2.data;

import com.olsonja.portfolio2.model.Project;
import com.olsonja.portfolio2.repository.ProjectRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Base64;


@Component
public class DataSeeder implements CommandLineRunner {

    private final ProjectRepository projectRepository;

    // Create an instance of Logger for this class
    private static final Logger logger = Logger.getLogger(DataSeeder.class);


    // Constructor
    public DataSeeder(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }


    // For converting any local image file to a byte array
    public byte[] convertImageToByteArray(String imagePath) {

        try (InputStream inputStream = Files.newInputStream(Paths.get(imagePath))) {
            return IOUtils.toByteArray(inputStream); // Convert the bytes from the InputStream into a Byte array
        } catch (IOException e) {
            System.out.println("*** AN EXCEPTION HAS OCCURRED ***:" + e);
            logger.error("An exception has occurred: " + e);
            return null;
        }
    }


    public void run(String... args) {

        if (projectRepository.count() == 0) {

            try {
                // Convert our image files to byte arrays
                byte[] image1 = convertImageToByteArray("C:\\Users\\jaols\\Portfolio2\\backend\\src\\main\\java\\com\\olsonja\\portfolio2\\data\\images\\project1.jpg");
                byte[] image2 = convertImageToByteArray("C:\\Users\\jaols\\Portfolio2\\backend\\src\\main\\java\\com\\olsonja\\portfolio2\\data\\images\\project2.jpg");
                byte[] image3 = convertImageToByteArray("C:\\Users\\jaols\\Portfolio2\\backend\\src\\main\\java\\com\\olsonja\\portfolio2\\data\\images\\project3.jpg");
                byte[] image4 = convertImageToByteArray("C:\\Users\\jaols\\Portfolio2\\backend\\src\\main\\java\\com\\olsonja\\portfolio2\\data\\images\\project4.jpg");
                byte[] image5 = convertImageToByteArray("C:\\Users\\jaols\\Portfolio2\\backend\\src\\main\\java\\com\\olsonja\\portfolio2\\data\\images\\project5.jpg");
                byte[] image6 = convertImageToByteArray("C:\\Users\\jaols\\Portfolio2\\backend\\src\\main\\java\\com\\olsonja\\portfolio2\\data\\images\\project6.jpg");

                if (image1 == null || image2 == null || image3 == null || image4 == null || image5 == null || image6 == null) {
                    System.out.println("*** ONE OR MORE OF THE IMAGES PROVIDED IS NULL UPON BYTE ARRAY CONVERSION. ***");
                    logger.error("*** ONE OR MORE OF THE IMAGES PROVIDED IS NULL UPON BYTE ARRAY CONVERSION. ***");
                } else {
                    // Convert image byte arrays to base64Images
                    String base64Image1 = Base64.getEncoder().encodeToString(image1);
                    String base64Image2 = Base64.getEncoder().encodeToString(image2);
                    String base64Image3 = Base64.getEncoder().encodeToString(image3);
                    String base64Image4 = Base64.getEncoder().encodeToString(image4);
                    String base64Image5 = Base64.getEncoder().encodeToString(image5);
                    String base64Image6 = Base64.getEncoder().encodeToString(image6);

                    // Create sample projects
                    Project project1 = new Project("Johnolson.dev", "A Java Web Dev Project", "A personal portfolio website made using a Spring Boot API, React frontend, and PostgreSQL remote database.","https://github.com/olsonja88/Portfolio2.git", base64Image1);
                    Project project2 = new Project("Artistry Loom", "An Art Station clone", "A clone of the website artstation.com, this is my most involved project yet!","https://github.com/olsonja88/Spring-React-Blog.git", base64Image2);
                    Project project3 = new Project("Orre Hunter","A Cross Platform App","An app used for shiny hunting in Pokemon games.","orrehunter.com", base64Image3);
                    Project project4 = new Project("Tasty Tales", "A Mobile Cookbook", "A mobile app with recipes that can be automatically translated into grocery lists!", "cooking.net", base64Image4);
                    Project project5 = new Project("Heli Hire", "A Helicopter Renting Web App", "A web app used to rent out helicopters in your local area", "helihire.com", base64Image5);
                    Project project6 = new Project("Trendy Steps", "A Mobile Shoe Retailing App", "A mobile app for selling nice shoes!", "trendysteps.net", base64Image6);

                    // Save projects to the repository
                    projectRepository.saveAll(Arrays.asList(project1, project2, project3, project4, project5, project6));

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
