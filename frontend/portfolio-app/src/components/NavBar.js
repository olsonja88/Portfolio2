// Navigation bar for all pages

import React from 'react';
import { useState } from 'react';
import { Container, Navbar, Nav, Button, Offcanvas, Form } from 'react-bootstrap';

const NavBar = () => {

    const [show, setShow] = useState(false);

    const handleShow = () => setShow(true);
    const handleClose = () => setShow(false);


    return (
        <Navbar>
            <Container fluid>
                <Navbar.Brand> </Navbar.Brand>
                <Button onClick={handleShow}>Navigate</Button>
                <Offcanvas show={show} onHide={handleClose}>
                    <Offcanvas.Header closeButton>
                        <Offcanvas.Title>Navigation</Offcanvas.Title>
                    </Offcanvas.Header>
                    <Offcanvas.Body>
                        <Nav.Link>Home</Nav.Link>
                        <Nav.Link>Portfolio</Nav.Link>
                        <Nav.Link>Blog</Nav.Link>
                        <Form className="mt-3">
                            <Form.Group controlId="basicSearch">
                                <Form.Label>Search</Form.Label>
                                <Form.Control type="search" placeholder="Search..." />
                            </Form.Group>
                            <Button type="submit" className="mt-2">Search</Button>
                        </Form>
                    </Offcanvas.Body>
                </Offcanvas>
            </Container>
        </Navbar>
    );
}

export default NavBar;
