import java.util.HashMap;
import java.util.Map;

public class java_03639_SessionManager_A01 {

    // Define a HashMap for storing sessions
    private Map<String, Session> sessionMap;

    // Default constructor
    public java_03639_SessionManager_A01() {
        this.sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public Session createSession(String sessionId) {
        // Check if sessionId is already used
        if (sessionMap.containsKey(sessionId)) {
            throw new RuntimeException("Session already exists with ID: " + sessionId);
        }

        // Create a new session
        Session session = new Session(sessionId);

        // Add the session to the session map
        sessionMap.put(sessionId, session);

        return session;
    }

    // Method to get a session
    public Session getSession(String sessionId) {
        // Check if sessionId is in the session map
        if (!sessionMap.containsKey(sessionId)) {
            throw new RuntimeException("No session exists with ID: " + sessionId);
        }

        // Get the session from the session map
        return sessionMap.get(sessionId);
    }

    // Session class
    public class Session {
        private String id;

        // Session constructor
        public java_03639_SessionManager_A01(String id) {
            this.id = id;
        }

        // Method to get session id
        public String getId() {
            return this.id;
        }
    }
}