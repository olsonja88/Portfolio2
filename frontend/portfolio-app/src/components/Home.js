// Landing page the entire project

import React from 'react';
import { Container } from 'react-bootstrap';
import PageHeader from './PageHeader';
import NavBar from './NavBar';
import AboutSection from './AboutSection';

const Home = () => {
    return (
        <Container>
            <PageHeader/>
            <NavBar/>
            <AboutSection/>
        </Container>
    );
}

export default Home;
