// Portfolio page to display projects

import React from 'react';
import { Container } from 'react-bootstrap';
import NavBar from '../components/NavBar';
import Footer from '../components/Footer';
import ProjectList from '../components/ProjectList';

const Portfolio = () => {
    return(
      <Container>
          <NavBar/>
          <ProjectList/>
          <Footer/>
      </Container>
    );
}

export default Portfolio;
