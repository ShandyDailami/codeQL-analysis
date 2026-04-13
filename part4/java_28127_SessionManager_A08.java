import java.util.HashMap;
import java.util.Map;

public class java_28127_SessionManager_A08 {

    // Define a private map to store session IDs and their corresponding sessions.
    private Map<String, Session> sessionMap;

    // Constructor
    public java_28127_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
    }

    // Method to start a session
    public Session startSession() {
        String sessionId = UUID.randomUUID().toString(); // Generate a random session ID
        Session session = new Session(sessionId);
        sessionMap.put(sessionId, session);
        return session;
    }

    // Method to get a session
    public Session getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new SessionNotFoundException("Session with ID " + sessionId + " not found.");
        }
    }

    // Method to stop a session
    public void stopSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            throw new SessionNotFoundException("Session with ID " + sessionId + " not found.");
        }
    }

    // Session class
    public class Session {
        private String id;

        public java_28127_SessionManager_A08(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        // Adding some integrity checks for session
        public void validateSession() {
            if (sessionMap.containsKey(id)) {
                System.out.println("Valid session: " + id);
            } else {
                throw new IntegrityFailureException("Invalid session: " + id);
            }
        }
    }

    // Custom exceptions
    class SessionNotFoundException extends RuntimeException {
        public java_28127_SessionManager_A08(String message) {
            super(message);
        }
    }

    class IntegrityFailureException extends RuntimeException {
        public java_28127_SessionManager_A08(String message) {
            super(message);
        }
    }
}