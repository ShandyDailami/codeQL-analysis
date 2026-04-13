public class java_11038_SessionManager_A01 {
    // Fields for the session
    private String sessionId;
    private User currentUser;

    // Constructor
    public java_11038_SessionManager_A01() {
    }

    // Getters and Setters
    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    // Method to start a session for a user
    public void startSession(String sessionId, User user) {
        this.sessionId = sessionId;
        this.currentUser = user;
    }

    // Method to end a session for a user
    public void endSession(String sessionId, User user) {
        if(this.sessionId.equals(sessionId) && this.currentUser.equals(user)) {
            this.sessionId = null;
            this.currentUser = null;
        }
    }
}

public class User {
    private String username;
    private String password;

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}