public class java_23021_SessionManager_A07 {
    private String userId;
    private boolean isLoggedIn;

    public java_23021_SessionManager_A07(String userId) {
        this.userId = userId;
        this.isLoggedIn = false;
    }

    public void login() {
        // Simulate login by checking if a user ID exists in a database
        if (userExistsInDatabase(userId)) {
            this.isLoggedIn = true;
        }
    }

    public void logout() {
        this.isLoggedIn = false;
    }

    private boolean userExistsInDatabase(String userId) {
        // Simulate a check against a database by returning a boolean
        return true;
    }
}

public class SessionManager {
    private Map<String, UserSession> sessions;

    public java_23021_SessionManager_A07() {
        this.sessions = new HashMap<>();
    }

    public UserSession getSession(String userId) {
        // Check if the session already exists, if it doesn't create a new one
        if (sessions.containsKey(userId)) {
            return sessions.get(userId);
        } else {
            UserSession session = new UserSession(userId);
            sessions.put(userId, session);
            return session;
        }
    }

    public void logout(String userId) {
        if (sessions.containsKey(userId)) {
            sessions.get(userId).logout();
        }
    }
}