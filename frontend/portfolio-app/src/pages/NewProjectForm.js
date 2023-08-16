// Form to create a new project in the database

import { useState, useEffect } from 'react';
import { Container } from 'react-bootstrap';
import PageHeader from '../components/PageHeader';
import NavBar from '../components/NavBar';
import Footer from '../components/Footer';

const NewProjectForm = () => {
    return (
      <Container>
          <PageHeader/>
          <NavBar/>

          <Container fluid className="content-section">
            <h2>Form goes here</h2>
          </Container>

          <Footer/>
      </Container>
    );
}

export default NewProjectForm;
