// NotificationService class
class NotificationService {

    // method to send notification
    public void sendNotification(String message) {
        System.out.println("Notification sent: " + message);
    }
}

// UserService class
class UserService {

    private NotificationService notificationService;

    // constructor injection
    public UserService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    // method to add user
    public void addUser(String username) {
        System.out.println("User added: " + username);

        // send notification
        notificationService.sendNotification("Welcome " + username);
    }
}

// Main class
public class BookMyStayApp {

    public static void main(String[] args) {

        // create objects
        NotificationService notificationService = new NotificationService();
        UserService userService = new UserService(notificationService);

        // add user
        userService.addUser("Alice");
    }
}