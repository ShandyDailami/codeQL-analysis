public class java_27881_SessionManager_A01 {
    private String username;
    private String password;

    public java_27881_SessionManager_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

public class SessionManager {
    private User loggedInUser;

    public void login(String username, String password) {
        // In a real-world application, we'd check against a database here
        // For the sake of example, we'll just assume this works correctly
        if (username.equals("admin") && password.equals("password")) {
            loggedInUser = new User(username, password);
        } else {
            throw new IllegalArgumentException("Invalid username or password");
        }
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void logout() {
        loggedInUser = null;
    }
}