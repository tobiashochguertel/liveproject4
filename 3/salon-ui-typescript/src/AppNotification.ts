import {Subject} from 'rxjs';
import {Notification} from "./AppNotificationComponent";

const subject = new Subject<Notification>();

export const appNotification = {
    showSuccess: (message: string, title = "Information") => subject.next({title, message, "variant": 'success'}),
    showError: (message: string) => subject.next({title: "Error ", message, "variant": 'danger'}),
    onChange: () => subject.asObservable()
};
