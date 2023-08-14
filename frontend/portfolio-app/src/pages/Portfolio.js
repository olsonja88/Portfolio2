// Portfolio page to display projects

import React from 'react';
import { Container } from 'react-bootstrap';
import PageHeader from '../components/PageHeader';
import NavBar from '../components/NavBar';
import Footer from '../components/Footer';

const Portfolio = () => {
    return(
      <Container>
          <PageHeader/>
          <NavBar/>
          <Footer/>
      </Container>
    );
}

export default Portfolio;
