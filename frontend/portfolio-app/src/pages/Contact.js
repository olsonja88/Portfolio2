import React, { useState, useEffect } from "react";
import PageHeader from '../components/PageHeader';
import NavBar from '../components/NavBar';
import { Container, Form, Button } from "react-bootstrap";
import Footer from '../components/Footer';
import Success from '../components/Success';
import { API_BASE_URL } from "../config";

const Contact = () => {

    const [formData, setFormData] = useState({
        firstName: '',
        lastName: '',
        email: '',
        message: ''
    });

    const [isFormValid, setFormValid] = useState(false);

    const [submitted, setSubmitted] = useState(false);

    const allowedDomains = ["gmail.com", "yahoo.com", "icloud.com", "outlook.com", "aol.com"];

    const handleInputChange = (event) => {
        const { name, value} = event.target;

        if (name === "email" && value.includes("@")) {
            const enteredDomain = value.split("@")[1].toLowerCase();
            const isDomainAllowed = allowedDomains.includes(enteredDomain);

            if (!isDomainAllowed) {
                setFormData({ ...formData, [name]: value, emailError: "Invalid email domain" })
            }
        }

        setFormData({ ...formData, [name]: value, emailError: "" });

        const allFieldsFilled = Object.values(formData).every((field) => field.trim() !== '');
        setFormValid(allFieldsFilled);
    };

    const handleSubmit = async (event) => {
        event.preventDefault();

        try {

            console.log('Form Data: ', formData);

            const response = await fetch(`${API_BASE_URL}/send-email`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(formData)
            });

            if (response.ok) {
                setFormData({
                    firstName: '',
                    lastName: '',
                    email: '',
                    message: '',
                });
                setSubmitted(true);
                console.log("Email sent successfully");
            } else {
                console.log("Email failed to send");
            }

        } catch (error) {
            console.error("Network error: " + error);
        }
    };

    useEffect(() => {
        const emailInput = document.querySelector('input[name="email"]');
        const emailTooltip = document.getElementById('emailTooltip');

        const displayTooltip = () => {
            emailTooltip.style.display = 'block';
        };

        const hideTooltip = (event) => {
            if (!emailTooltip.contains(event.target) && event.target !== emailInput) {
                emailTooltip.style.display = 'none';
            }
        };

        emailInput.addEventListener('click', displayTooltip);
        document.addEventListener('click', hideTooltip);

        return () => {
            emailInput.removeEventListener('click', displayTooltip);
            document.removeEventListener('click', displayTooltip);
        };
    }, []);


    return (
        <Container>
            <PageHeader/>
            <NavBar/>
            {submitted ? (<Success/>) : (
                <Container fluid className="content-section">
                    <Form onSubmit={handleSubmit}>
                        <Form.Group className="mb-3" controlId="formBasicFirstName">
                            <Form.Label>First Name</Form.Label>
                            <Form.Control type="text" placeholder="Your first name" value={formData.firstName} name="firstName" onChange={handleInputChange}
                            className={errors.firstName ? "invalid-field" : ""} />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formBasicLastName">
                            <Form.Label>Last Name</Form.Label>
                            <Form.Control type="text" placeholder="Your last name" value={formData.lastName} name="lastName" onChange={handleInputChange}
                            className={errors.lastName ? "invalid-field" : ""} />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formBasicEmail">
                            <Form.Label>Email Address</Form.Label>
                            <div className="email-tooltip" id="emailTooltip">
                                <ul>
                                    <li>gmail.com</li>
                                    <li>yahoo.com</li>
                                    <li>icloud.com</li>
                                    <li>outlook.com</li>
                                    <li>aol.com</li>
                                </ul>
                            </div>
                            <Form.Control type="email" placeholder="Enter email" value={formData.email} name="email" onChange={handleInputChange}
                            className={errors.email ? "invalid-field" : ""} />
                            <Form.Text className="muted">
                                Your email will never be shared with anyone else.
                            </Form.Text>
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formBasicMessage">
                            <Form.Label>Message</Form.Label>
                            <Form.Control as="textarea" rows={5} value={formData.message} name="message" onChange={handleInputChange}
                            className={errors.message ? "invalid-field" : ""} />
                        </Form.Group>
                        <Button variant="primary" type="submit" disabled={!isFormValid}>
                            Submit
                        </Button>
                    </Form>
                </Container>
            )}
            <Footer/>
        </Container>
    );
}

export default Contact;
