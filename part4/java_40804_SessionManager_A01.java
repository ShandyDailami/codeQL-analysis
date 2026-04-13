import java.util.HashMap;
import java.util.Map;

public class java_40804_SessionManager_A01 {

    // A map to hold our sessions
    private Map<String, Session> sessions;

    public java_40804_SessionManager_A01() {
        // Initialize our sessions map
        sessions = new HashMap<>();
    }

    // Method to create a new session
    public Session createSession(String sessionId) {
        // Create a new Session object
        Session session = new Session(sessionId);
        
        // Add the new session to our map
        sessions.put(sessionId, session);

        return session;
    }

    // Method to get a session from our map
    public Session getSession(String sessionId) {
        // Return the session from our map, or null if not found
        return sessions.get(sessionId);
    }

    // Class to represent a session
    public class Session {

        private String id;

        public java_40804_SessionManager_A01(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}