public class java_37940_SessionManager_A03 {
    private static final String SECRET_KEY = "A03_Injection"; // Secret key for session validation

    private SessionContext sessionContext;

    public java_37940_SessionManager_A03() {
        sessionContext = new SessionContext();
    }

    public void startSession(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        String sessionId = UUID.randomUUID().toString(); // Generate a new session ID
        sessionContext.setSessionId(sessionId);
        sessionContext.setUser(user);
   
        // Validate session with the secret key
        if (!isSessionValid(sessionId)) {
            throw new SecurityException("Invalid session");
        }
    }

    private boolean isSessionValid(String sessionId) {
        return sessionId.equals(sessionContext.getSessionId()) && sessionContext.getUser().equals(sessionContext.getUser());
    }

    public User getUserFromSession(String sessionId) {
        if (!isSessionValid(sessionId)) {
            throw new SecurityException("Invalid session");
        }
        return sessionContext.getUser();
    }

    public void endSession(String sessionId) {
        if (!isSessionValid(sessionId)) {
            throw new SecurityException("Invalid session");
        }
        sessionContext.setSessionId(null);
        sessionContext.setUser(null);
    }
}

class SessionContext {
    private String sessionId;
    private User user;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

class User {
    private String username;

    public java_37940_SessionManager_A03(String username) {
        this.username = username;
    }

    // Getters and setters
}