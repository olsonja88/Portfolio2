// List of projects, fetched from backend

import { useEffect, useState } from 'react';
import { Container, Row, Card } from 'react-bootstrap';

const ProjectList = () => {

    const [projects, setProjects] = useState([]);
    const [loading, setLoading] = useState(false);

    useEffect(() => {

        setLoading(true);

        fetch('/api/projects.js')
            .then(response => response.json())
            .then(data => {
                setProjects(data);
                setLoading(false);
                })
            .catch(error => {
                console.error("Error fetching data: ", error);
            })
    }, []);

    const projectList = projects.map(project => {
        return <div key={project.id} className="col-lg-4 col-md-6 col-sm-12 mb-4">
            <Card>
                <Card.Body>
                    <Card.Title>{project.name}</Card.Title>
                    <Card.Text>{project.description}</Card.Text>
                </Card.Body>
            </Card>
        </div>
    });

    if (loading) {
        return (
            <p>Loading...</p>
        );
    }

    return (
        <Container className="content-section">
            <h1>Project List</h1>
            <Row>
                {projectList}
            </Row>
        </Container>
    );
}

export default ProjectList;
