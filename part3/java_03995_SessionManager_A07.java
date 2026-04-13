import java.util.HashMap;

public class java_03995_SessionManager_A07 {
    // A map to store sessions.
    private HashMap<String, Session> sessions;

    public java_03995_SessionManager_A07() {
        // Initialize the sessions map.
        sessions = new HashMap<>();
    }

    public String createSession(String userId) {
        // Generate a new session ID.
        String sessionId = generateSessionId();

        // Create a new session and store it in the map.
        sessions.put(sessionId, new Session(userId));

        return sessionId;
    }

    public void closeSession(String sessionId) {
        // Remove the session from the map.
        sessions.remove(sessionId);
    }

    public void authenticateUser(String sessionId, String userId) {
        // Find the session.
        Session session = sessions.get(sessionId);

        // If the session exists and the user is authenticated, set the user ID.
        if (session != null && session.isAuthenticated()) {
            session.setUserId(userId);
        }
    }

    public String getUserId(String sessionId) {
        // Find the session.
        Session session = sessions.get(sessionId);

        // If the session exists and the user is authenticated, return the user ID.
        if (session != null && session.isAuthenticated()) {
            return session.getUserId();
        }

        // If the session does not exist or the user is not authenticated, return null.
        return null;
    }

    // The Session class represents a user session.
    private class Session {
        private String userId;
        private boolean authenticated;

        public java_03995_SessionManager_A07(String userId) {
            this.userId = userId;
            this.authenticated = false;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getUserId() {
            return userId;
        }

        public void setAuthenticated(boolean authenticated) {
            this.authenticated = authenticated;
        }

        public boolean isAuthenticated() {
            return authenticated;
        }
    }
}