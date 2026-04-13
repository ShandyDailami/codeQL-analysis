public class java_14544_SessionManager_A01 {

    // Private field for storing the user
    private User user;

    // Public constructor for initializing a User
    public java_14544_SessionManager_A01(User user) {
        this.user = user;
    }

    // Method to start a session
    public void startSession() {
        // The user's session could be started here, for example:
        System.out.println(user.getName() + " has started a session.");
    }

    // Method to end the session
    public void endSession() {
        // The user's session could be ended here, for example:
        System.out.println(user.getName() + " has ended a session.");
   
        // Simulate the session expiration by 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // If session is ended, print a message
        System.out.println(user.getName() + " has ended a session.");
    }
}

public class User {

    private String name;

    // Public constructor for initializing a User
    public java_14544_SessionManager_A01(String name) {
        this.name = name;
    }

    // Method to get the user's name
    public String getName() {
        return name;
    }
}

public class Main {

    public static void main(String[] args) {
        // Create a new user
        User user = new User("John");

        // Create a new session manager for the user
        SessionManager sessionManager = new SessionManager(user);

        // Start the session
        sessionManager.startSession();

        // End the session for a simulated session expiration
        sessionManager.endSession();
    }
}