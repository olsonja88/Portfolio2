// Individual project, fetched from backend

import { useState, useEffect } from 'react';
import { useParams, Link } from 'react-router-dom';
import { Container, Row, Col, Image } from 'react-bootstrap';
import { API_BASE_URL } from "../config";

const ProjectDetail = () => {

    const { projectId } = useParams();
    const [project, setProject] = useState({});
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState(null);

    useEffect(() => {

        setLoading(true);

        const apiUrl = `${API_BASE_URL}/projects/${projectId}`;

        const fetchedProject = fetch(apiUrl)
            .then(response => response.json())
            .then(data => {
                setProject(data);
                setLoading(false);
            })
            .catch(error => {
                console.error("Error fetching data: ", error);
                setError("An error occurred while fetching data.");
                setLoading(false);
            })
    }, [projectId]);

    if (error) {
        return <p>Error: {error}</p>;
    }

    if (loading) {
        return (
            <p>Loading...</p>
        );
    }

    return (
        <Container fluid className="content-section">
            <Row>
                <Col>
                    <Image fluid src={`data:image/jpeg;base64,${project.base64Image}`}/>
                </Col>
                <Col>
                    <h1>{project.name}</h1>
                    <p>{project.briefSummary}</p>
                    <p>{project.description}</p>
                    <Link to={'/portfolio'} className="btn">Portfolio </Link>
                </Col>
            </Row>
        </Container>
    );
}

export default ProjectDetail;
