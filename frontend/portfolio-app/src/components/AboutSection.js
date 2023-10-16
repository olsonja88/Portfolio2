// About section for the Home Page

import React from 'react';
import { Container, Row, Col, Image, Accordion, ListGroup } from 'react-bootstrap';
import ProfilePic from "../assets/NewProfilePic2.jpg";
import {FaGithub, FaLinkedin} from "react-icons/fa";

const AboutSection = () => {
    return (
        <Container fluid className="content-section">
            <Row>
                <Col></Col>
                <Col>
                    {/* Image and about */}
                    <Image roundedCircle src={ProfilePic} fluid/>
                    <p className="mt-5">Computer Science Student at Metropolitan State University, interested in Full Stack Web Development.</p>
                    {/* List of classes taken */}
                    <Accordion className="custom-accordion">
                        <Accordion.Item eventKey="0">
                            <Accordion.Header>
                                Relevant Completed Courses
                            </Accordion.Header>
                            <Accordion.Body>
                                <ListGroup as="ul">
                                    <ListGroup.Item as="li">Intro to Java</ListGroup.Item>
                                    <ListGroup.Item as="li">Intro to Data Structures (Java)</ListGroup.Item>
                                    <ListGroup.Item as="li">Computer Organization & Architecture</ListGroup.Item>
                                    <ListGroup.Item as="li">Intro to C</ListGroup.Item>
                                    <ListGroup.Item as="li">Intro to Programming Concepts (Python)</ListGroup.Item>
                                </ListGroup>
                            </Accordion.Body>
                        </Accordion.Item>
                    </Accordion>
                    <a href="https://github.com/olsonja88" target="_blank" rel="noopener noreferrer">
                        <FaGithub className="socials-icon" />
                    </a>
                    <a  href="https://www.linkedin.com/in/john-olson-036096276/" target="_blank" rel="noopener noreferrer">
                        <FaLinkedin className="socials-icon" />
                    </a>
                </Col>
                <Col></Col>
            </Row>
        </Container>
    );
}

export default AboutSection;



