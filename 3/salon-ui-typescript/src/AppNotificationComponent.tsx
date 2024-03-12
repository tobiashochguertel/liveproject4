import React, {useEffect, useState} from 'react';
import {Alert} from "react-bootstrap";
import {appNotification} from './AppNotification';

const TEN_SECONDS = 10 * 1000;

export interface Notification {
    title: string,
    variant: string,
    message: string,
}

type AppNotificationComponentProps = {};

/* App Notification Component */
const AppNotificationComponent = (props: AppNotificationComponentProps) => {
    const [notification, setNotification] = useState({
        "show": false,
        "title": '',
        "variant": '',
        "message": '',
    });

    const reset = () => {
        setNotification({
            "show": false,
            "title": '',
            "variant": '',
            "message": '',
        });
    }

    const onNotificationReceived = (res: Notification) => {
        setNotification({
            "show": true,
            "title": res.title,
            "variant": res.variant,
            "message": res.message
        });

        setTimeout(() => {
            reset();
        }, TEN_SECONDS)
    }

    useEffect(() => {
        const subscription = appNotification.onChange().subscribe((res) => {
            onNotificationReceived(res);
        });

        // Clean up: unsubscribe on unmount
        return () => {
            subscription.unsubscribe();
        };
    }, [onNotificationReceived]);

    const {show, title, message, variant} = notification;

    return (
        <React.Fragment>
            {show === true && <div className="message-container ">
                <div className="container">
                    <Alert variant={variant} onClose={reset} dismissible>
                        <Alert.Heading>{title}</Alert.Heading>
                        <p>
                            {message}
                        </p>
                    </Alert>
                </div>
            </div>}
        </React.Fragment>
    );
}

export default AppNotificationComponent;