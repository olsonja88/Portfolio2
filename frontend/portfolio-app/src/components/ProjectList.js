// List of projects, fetched from backend

import { useEffect, useState } from 'react';
import { Container, Row, Col, Card, Image } from 'react-bootstrap';

const ProjectList = () => {

    const [projects, setProjects] = useState([]);
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState(null);

    useEffect(() => {

        setLoading(true);

        fetch('/api/projects')
            .then(response => response.json())
            .then(data => {
                setProjects(data);
                setLoading(false);
                })
            .catch(error => {
                console.error("Error fetching data: ", error);
                setError("An error occurred while fetching data.");
                setLoading(false);
            })
    }, []);

    const projectList = projects.map(project => {
        return <Col key={project.id} className="col-md-4 mb-4">
            <Card>
                <Card.Body>
                    <Card.Img fluid variant="top" src={`data:image/jpeg;base64,` + project.base64Image} />
                    <Card.Title>{project.name}</Card.Title>
                    <Card.Text>{project.briefSummary}</Card.Text>
                </Card.Body>
            </Card>
        </Col>
    });

    if (error) {
        return <p>Error: {error}</p>;
    }

    if (loading) {
        return (
            <p>Loading...</p>
        );
    }

    return (
        <Container className="content-section">
            <h1 className="mb-4">Project List</h1>
            <Row>
                {projectList}
            </Row>
        </Container>
    );
}

export default ProjectList;
