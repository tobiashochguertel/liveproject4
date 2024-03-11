import React from 'react';
import './App.css';
import './Header.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import {Container} from "react-bootstrap";

function App() {
    return (
        <>
            <Container>
                <header className="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
                    <a href="/"
                       className="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
                        {/*                        <svg className="bi me-2" width="40" height="32">
                            <use href="#"></use>
                        </svg>*/}
                        <span className="fs-4">Ar Salon & Day Spa</span>
                    </a>

                    {/*                    <ul className="nav nav-pills">
                        <li className="nav-item"><a href="#" className="nav-link active" aria-current="page">Home</a>
                        </li>
                        <li className="nav-item"><a href="#" className="nav-link">Features</a></li>
                        <li className="nav-item"><a href="#" className="nav-link">Pricing</a></li>
                        <li className="nav-item"><a href="#" className="nav-link">FAQs</a></li>
                        <li className="nav-item"><a href="#" className="nav-link">About</a></li>
                    </ul>*/}
                </header>
            </Container>
            <Container>
                Edit <span style={{color: "red"}}>`src/App.js`</span> and save to reload.
            </Container>
        </>
    );
}

export default App;
