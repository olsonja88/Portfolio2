// Page to display if no page is available

import React from 'react';
import { Container } from 'react-bootstrap';
import NavBar from '../components/NavBar';
import Footer from '../components/Footer';

const NoPage = () => {
    return (
        <Container>
            <NavBar/>
            <Container fluid className="bg-light">
                <p>We couldn't find the page you're looking for :(</p>
            </Container>
            <Footer/>
        </Container>
    );
}

export default NoPage;
