// Menu for site management functions

import { Container, Row, Col, Button } from 'react-bootstrap';

const ManagerMenu = () => {
    return (
      <Container fluid className="content-section">
        <h2>Management Options</h2>
        <Row className="mt-4">
            <Col>
                <h3>Projects</h3>
                <Button className="mt-3" href="/new-project-form">Create a new Project</Button>
            </Col>
            <Col>
                <h3>Categories & Posts</h3>
            </Col>
        </Row>
      </Container>
    );
}

export default ManagerMenu;
