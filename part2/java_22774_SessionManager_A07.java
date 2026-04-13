import java.util.HashMap;
import java.util.Map;

public class java_22774_SessionManager_A07 {
    // A map to hold userID and session objects
    private Map<String, Session> sessionMap;

    public java_22774_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public Session createSession(String userID) {
        // Generate a unique ID for the session
        String sessionID = userID + System.currentTimeMillis();

        // Create a new session object
        Session session = new Session(sessionID, userID);

        // Store the session object in the map
        sessionMap.put(sessionID, session);

        return session;
    }

    // Method to validate a session
    public boolean validateSession(String sessionID, String userID) {
        // Check if the session ID and user ID match
        Session session = sessionMap.get(sessionID);
        if (session != null && session.getUserID().equals(userID)) {
            return true;
        }

        return false;
    }

    // Method to end a session
    public void endSession(String sessionID) {
        // Remove the session object from the map
        sessionMap.remove(sessionID);
    }

    // Session class to hold session ID and user ID
    public class Session {
        private String sessionID;
        private String userID;

        public java_22774_SessionManager_A07(String sessionID, String userID) {
            this.sessionID = sessionID;
            this.userID = userID;
        }

        public String getSessionID() {
            return sessionID;
        }

        public String getUserID() {
            return userID;
        }
    }
}