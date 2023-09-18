// Navigation bar for all pages

import React from 'react';
import { useState } from 'react';
import { Container, Navbar, Nav, Button, Offcanvas } from 'react-bootstrap';

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
                        <Nav.Link href="/">Home</Nav.Link>
                        <Nav.Link href="/portfolio">Portfolio</Nav.Link>
                        <Nav.Link href="/contact">Contact</Nav.Link>
                    </Offcanvas.Body>
                </Offcanvas>
            </Container>
        </Navbar>
    );
}

export default NavBar;
