import React from 'react';
import './App.css';
import './Header.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import {Container, Navbar} from "react-bootstrap";
import LoadingIndicatorComponent from './LoadingIndicatorComponent';
import ChooseService from './ChooseService';
import AppNotificationComponent from './AppNotificationComponent';

function App() {
    return (
        <>
            <Navbar expand="lg"
                    className="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
                <Container>
                    <Navbar.Brand href="/" className="fs-4">Ar Salon & Day Spa</Navbar.Brand>
                    <Navbar.Toggle aria-controls="basic-navbar-nav"/>
                </Container>
            </Navbar>
            <Container>
                <LoadingIndicatorComponent/>
                <ChooseService></ChooseService>
                <AppNotificationComponent></AppNotificationComponent>
            </Container>
        </>
    );
}

export default App;
