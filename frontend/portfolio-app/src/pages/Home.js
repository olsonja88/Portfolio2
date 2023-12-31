// Landing page the entire project

import React from 'react';
import { Container } from 'react-bootstrap';
import NavBar from '../components/NavBar';
import AboutSection from '../components/AboutSection';
import Footer from '../components/Footer';

const Home = () => {
    return (
        <Container>
            <NavBar/>
            <AboutSection/>
            <Footer/>
        </Container>
    );
}

export default Home;
