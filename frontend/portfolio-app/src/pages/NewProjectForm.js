// Form to create a new project in the database

import { Container, Button, Form } from 'react-bootstrap';
import PageHeader from '../components/PageHeader';
import NavBar from '../components/NavBar';
import Footer from '../components/Footer';

const NewProjectForm = () => {
    return (
      <Container>
          <PageHeader/>
          <NavBar/>
          <Container fluid className="content-section">
            <Form>
                <Form.Group className="mb-3" controlId="projectForm.Name">
                    <Form.Label>Project Name</Form.Label>
                    <Form.Control placeholder="New exciting project..." />
                </Form.Group>
                <Form.Group className="mb-3" controlId="projectForm.Link">
                    <Form.Label>GitHub Link</Form.Label>
                    <Form.Control type="link" placeholder="https://github.com/"/>
                </Form.Group>
                <Form.Group className="mb-3" controlId="projectForm.Description">
                    <Form.Label>Project Description</Form.Label>
                    <Form.Control as="textarea" rows={3} placeholder="A brand new sparkling app!"/>
                </Form.Group>
                <Button type="submit">Submit</Button>
            </Form>
          </Container>
          <Footer/>
      </Container>
    );
}

export default NewProjectForm;
