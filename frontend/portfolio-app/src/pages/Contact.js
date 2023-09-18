import React, { useState } from "react";
import PageHeader from '../components/PageHeader';
import NavBar from '../components/NavBar';
import { Container, Form, Button } from "react-bootstrap";
import Footer from '../components/Footer';
import Success from '../components/Success';
import { API_BASE_URL } from "../../config";

const Contact = () => {

    const [formData, setFormData] = useState({
        firstName: '',
        lastName: '',
        email: '',
        message: ''
    });

    const [submitted, setSubmitted] = useState(false);

    const handleInputChange = (event) => {
        const { name, value} = event.target;
        setFormData({ ...formData, [name]: value });
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


    return (
        <Container>
            <PageHeader/>
            <NavBar/>
            {submitted ? (<Success/>) : (
                <Container fluid className="content-section">
                    <Form onSubmit={handleSubmit}>
                        <Form.Group className="mb-3" controlId="formBasicFirstName">
                            <Form.Label>First Name</Form.Label>
                            <Form.Control type="text" placeholder="Your first name" value={formData.firstName} name="firstName" onChange={handleInputChange} />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formBasicLastName">
                            <Form.Label>Last Name</Form.Label>
                            <Form.Control type="text" placeholder="Your last name" value={formData.lastName} name="lastName" onChange={handleInputChange} />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formBasicEmail">
                            <Form.Label>Email Address</Form.Label>
                            <Form.Control type="email" placeholder="Enter email" value={formData.email} name="email" onChange={handleInputChange} />
                            <Form.Text className="muted">
                                Your email will never be shared with anyone else.
                            </Form.Text>
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formBasicMessage">
                            <Form.Label>Message</Form.Label>
                            <Form.Control as="textarea" rows={5} value={formData.message} name="message" onChange={handleInputChange} />
                        </Form.Group>
                        <Button variant="primary" type="submit">
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
