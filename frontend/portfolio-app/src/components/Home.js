// Landing page the entire project

import React from 'react';
import { Container } from 'react-bootstrap';
import PageHeader from './PageHeader';
import NavBar from './NavBar';
import AboutSection from './AboutSection';
import Footer from './Footer';

const Home = () => {
    return (
        <Container>
            <PageHeader/>
            <NavBar/>
            <AboutSection/>
            <Footer/>
        </Container>
    );
}

export default Home;
