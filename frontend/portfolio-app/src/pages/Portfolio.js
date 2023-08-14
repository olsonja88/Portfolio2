// Portfolio page to display projects

import React from 'react';
import { Container } from 'react-bootstrap';
import PageHeader from '../components/PageHeader';
import NavBar from '../components/NavBar';
import Footer from '../components/Footer';
import ProjectList from '../components/ProjectList';

const Portfolio = () => {
    return(
      <Container>
          <PageHeader/>
          <NavBar/>
          <ProjectList/>
          <Footer/>
      </Container>
    );
}

export default Portfolio;
