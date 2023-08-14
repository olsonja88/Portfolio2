// List of projects, fetched from backend

import { useEffect, useState } from 'react';
import { Container } from 'react-bootstrap';

const ProjectList = () => {

    const [projects, setProjects] = useState([]);
    const [loading, setLoading] = useState(false);

    useEffect(() => {

        setLoading(true);

        fetch('/api/projects')
            .then(response => response.json())
            .then(data => {
                setProjects(data)
                setLoading(false)
                })
    }, []);

    if (loading) {
        return (
            <p>Loading...</p>
        );
    }

    return (
        <p>Projects</p>
    );
}

export default ProjectList;
