// Navigation bar for all pages

import React from 'react';
import { useState } from 'react';
import { Container, Navbar, Button, Offcanvas } from 'react-bootstrap';

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
                        <p>Content</p>
                    </Offcanvas.Body>
                </Offcanvas>
            </Container>
        </Navbar>
    );
}

export default NavBar;
