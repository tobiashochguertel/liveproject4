import React, {useEffect, useState} from 'react';
import {Button, Card, Col, Container, ListGroup, Row} from 'react-bootstrap';
import {appNotification} from './AppNotification';
import {API_URL} from './configuration';
import {loadingIndicator} from './LoadingIndicator';

type ChooseServiceProps = {};

type SalonServiceDetail = {
    id: number;
    name: string;
    description: string;
    price: number;
    timeInMinutes: number;
}

/* Choose Service Component*/
const ChooseService = (props: ChooseServiceProps) => {
    const [items, setItems] = useState<SalonServiceDetail[]>([]);

    const handleErrors = (response: any): Promise<Response> => {
        return new Promise((resolve, reject) => {
            if (!response.ok) {
                getErrorText(response).then(res => {
                    reject(res);
                })
            } else {
                resolve(response);
            }
        });
    }

    const getErrorText = async (response: any) => {
        let result = null;
        try {
            result = await response.json()
        } catch (e) {

        }

        if (result && result["message"])
            return result["message"]
        return JSON.stringify(result);
    };

    const onReceiveData = (items: SalonServiceDetail[]) => {
        loadingIndicator.hide();
        setItems(items);
    }

    const onError = (error: string) => {
        loadingIndicator.hide();
        appNotification.showError("Unable to retrieve Spa Services  - " + error)
    }

    const downloadServices = async () => {
        loadingIndicator.show();

        const url = API_URL + 'services/retrieveAvailableSalonServices';

        fetch(url)
            .then(res => handleErrors(res))
            // @ts-ignore
            .then(res => res.json())
            .then((results) => onReceiveData(results))
            .catch(errorObject => onError(errorObject))
    }

    const bookFor = (item: SalonServiceDetail) => {
        console.log(item)
    }

    useEffect(() => {
        if (items.length === 0) {
            downloadServices();
        }
    }, [downloadServices]);

    return (
        <React.Fragment>
            <Container>
                <Row>

                    {items.map((item: SalonServiceDetail, index) => {
                        return (
                            <Col xs={3}>
                                <Card key={index} className={"rounded-3 mb-4 shadow-sm"}>
                                    <Card.Header as="h4" className={"my-0 font-weight-normal"}>{item.name}</Card.Header>
                                    <Card.Body>
                                        <Card.Title as="h1"
                                                    className={"card-title pricing-card-title text-center"}>${item.price}</Card.Title>
                                        <ListGroup variant="flush" className={"mt-3 mb-4"}>
                                            <ListGroup.Item>{item.description}</ListGroup.Item>
                                            <ListGroup.Item>{item.timeInMinutes} Minutes</ListGroup.Item>
                                        </ListGroup>
                                        <Button variant="outline-primary" className={"btn btn-lg btn-block"}
                                                onClick={(evt) => bookFor(item)}>Book
                                            Now</Button>
                                    </Card.Body>
                                </Card>
                            </Col>
                        );
                    })}
                </Row>
            </Container>
        </React.Fragment>
    );
}

export default ChooseService;
