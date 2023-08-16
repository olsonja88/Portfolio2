// Page for managing projects and posts, will require sign-in

import React from 'react';
import { Container } from 'react-bootstrap';
import PageHeader from '../components/PageHeader';
import NavBar from '../components/NavBar';
import ManagerMenu from '../components/ManagerMenu';
import Footer from '../components/Footer';

const Manage = () => {
    return (
        <Container>
            <PageHeader/>
            <NavBar/>
            <ManagerMenu/>
            <Footer/>
        </Container>
    );
}

export default Manage;
