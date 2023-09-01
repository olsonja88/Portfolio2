// In depth view of any given project

import React from 'react';
import { Container } from 'react-bootstrap';
import PageHeader from '../components/PageHeader';
import NavBar from '../components/NavBar';
import Footer from '../components/Footer';
import ProjectDetail from '../components/ProjectDetail';

const ProjectInDepth = () => {
  return (
      <Container>
          <PageHeader/>
          <NavBar/>
          <ProjectDetail/>
          <Footer/>
      </Container>
  );
}

export default ProjectInDepth;
