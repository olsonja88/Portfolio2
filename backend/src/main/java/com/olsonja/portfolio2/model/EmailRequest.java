package com.olsonja.portfolio2.model;

public class EmailRequest {

    // Instance Variables
    private String firstName;
    private String lastName;
    private String email;
    private String message;


    // Constructor
    public EmailRequest(String firstName, String lastName, String email, String message) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.message = message;
    }


    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getMessage() {
        return message;
    }


    // Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String subject) {
        this.email = email;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
