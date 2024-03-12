import React from 'react';
import './App.css';
import './Header.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import {Container, Nav, Navbar, NavDropdown} from "react-bootstrap";

function App() {
    return (
        <>
            <Navbar expand="lg"
                    className="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
                <Container>
                    <Navbar.Brand href="/" className="fs-4">Ar Salon & Day Spa</Navbar.Brand>
                    <Navbar.Toggle aria-controls="basic-navbar-nav"/>
                    {/*                    <Navbar.Collapse id="basic-navbar-nav">
                        <Nav className="me-auto">
                            <Nav.Link href="#home">Home</Nav.Link>
                            <Nav.Link href="#link">Link</Nav.Link>
                            <NavDropdown title="Dropdown" id="basic-nav-dropdown">
                                <NavDropdown.Item href="#action/3.1">Action</NavDropdown.Item>
                                <NavDropdown.Item href="#action/3.2">
                                    Another action
                                </NavDropdown.Item>
                                <NavDropdown.Item href="#action/3.3">Something</NavDropdown.Item>
                                <NavDropdown.Divider/>
                                <NavDropdown.Item href="#action/3.4">
                                    Separated link
                                </NavDropdown.Item>
                            </NavDropdown>
                        </Nav>
                    </Navbar.Collapse>*/}
                </Container>
            </Navbar>
            <Container>
                Edit <span style={{color: "red"}}>`src/App.js`</span> and save to reload.
            </Container>
        </>
    );
}

export default App;
