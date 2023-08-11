// About section for the Home Page

import React from 'react';
import { Container, Row, Col, Image, Accordion } from 'react-bootstrap';
import ProfilePic from "../assets/ProfilePic2.jpg";

const AboutSection = () => {
    return (
        <Container fluid className="about-section">
            <Row>
                <Col></Col>
                <Col>
                    <Image roundedCircle src={ProfilePic} fluid/>
                    <p className="mt-5">Computer Science Student at Metropolitan State University.  Interested in Full Stack Web Development with an emphasis on responsive Frontends in React.</p>
                </Col>
                <Col></Col>
            </Row>
        </Container>
    );
}

export default AboutSection;



