import java.util.HashMap;
import java.util.Map;

public class java_21428_SessionManager_A08 {
    // A Map for storing sessions, where the key is the session ID and the value is the session object
    private Map<String, Session> sessionMap;

    // Default constructor
    public java_21428_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public Session createSession(String sessionId) {
        // Create a new Session object
        Session session = new Session(sessionId);

        // Add the session to the map
        sessionMap.put(sessionId, session);

        // Return the created session
        return session;
    }

    // Method to get a session
    public Session getSession(String sessionId) {
        // Return the session from the map
        return sessionMap.get(sessionId);
    }

    // Class for Session
    public class Session {
        private String sessionId;

        // Constructor
        public java_21428_SessionManager_A08(String sessionId) {
            this.sessionId = sessionId;
        }

        // Method to set the session ID
        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        // Method to get the session ID
        public String getSessionId() {
            return this.sessionId;
        }

        // Method to check if the session ID is valid
        public boolean isValid() {
            // For simplicity, we'll assume a valid session ID if it exists in the map
            return sessionMap.containsKey(this.sessionId);
        }

        // Method to check if the session ID is valid
        public boolean isInvalid() {
            // For simplicity, we'll assume an invalid session ID if it does not exist in the map
            return !sessionMap.containsKey(this.sessionId);
        }

        // Method to destroy the session
        public void destroy() {
            // Remove the session from the map
            sessionMap.remove(this.sessionId);
        }
    }
}