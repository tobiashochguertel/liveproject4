import React, {useEffect, useState} from 'react';
import {ProgressBar} from "react-bootstrap";
import {loadingIndicator} from './LoadingIndicator';

type LoadingIndicatorProps = {};
/* Loading Indicator Component */
const LoadingIndicatorComponent = (props: LoadingIndicatorProps) => {
    const [showLoading, setShowLoading] = useState(false);

    useEffect(() => {
        const subscription = loadingIndicator.onChange().subscribe(
            (value) => setShowLoading(value),
            (error) => console.error(error)
        );

        // Cleanup: unsubscribe on unmount
        return () => {
            subscription.unsubscribe();
        };
    }, []);

    return (
        <React.Fragment>
            {showLoading && <div className="progress-container"><ProgressBar animated now={100}/></div>}
        </React.Fragment>
    );
}

export default LoadingIndicatorComponent;
