public class java_17985_SessionManager_A07 {
    private static SessionManager instance;
    private User loggedInUser;

    private java_17985_SessionManager_A07() {
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public void login(String username, String password) throws AuthFailure {
        // Simulate authentication process by setting loggedInUser
        loggedInUser = new User(username, password);
    }

    public void logout() {
        // Remove the loggedInUser
        loggedInUser = null;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }
}

class User {
    private String username;
    private String password;

    public java_17985_SessionManager_A07(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

class AuthFailure extends Exception {
    // Simulate AuthFailure exception
}