public class java_11333_SessionManager_A01 {
    private String id;
    private String username;
    private String password;

    // getters and setters
    // ...
}

public class SessionManager {
    private User currentUser;

    public void login(String username, String password) {
        // Implementation for security sensitive operations
        // ...

        // Set the logged in user
        currentUser = user;
    }

    public void logout() {
        // Implementation for security sensitive operations
        // ...

        // Unset the logged in user
        currentUser = null;
    }

    public User getCurrentUser() {
        // Implementation for security sensitive operations
        // ...

        return currentUser;
    }
}