public class java_39126_SessionManager_A08 {
    // User is a custom class for representing user details
    private User loggedInUser;

    public java_39126_SessionManager_A08() {
        loggedInUser = null;
    }

    public void setLoggedInUser(User user) {
        loggedInUser = user;
    }

    public void checkValidSession() {
        if (loggedInUser == null) {
            System.out.println("Error: No valid session found.");
        } else {
            System.out.println("Session valid for user: " + loggedInUser.getUsername());
        }
    }
}

public class User {
    private String username;

    public java_39126_SessionManager_A08(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a new session manager
        SessionManager sessionManager = new SessionManager();

        // Try to login as a valid user
        User validUser = new User("validUser");
        sessionManager.setLoggedInUser(validUser);
        sessionManager.checkValidSession();

        // Try to login as an invalid user
        User invalidUser = new User("invalidUser");
        sessionManager.setLoggedInUser(invalidUser);
        sessionManager.checkValidSession();
    }
}