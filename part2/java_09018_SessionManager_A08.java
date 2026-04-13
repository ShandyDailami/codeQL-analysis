import java.util.HashMap;
import java.util.Map;

public class java_09018_SessionManager_A08 {

    // A map to store sessions
    private Map<String, Session> sessionMap;

    // A map to store unique session IDs
    private Map<String, String> sessionIdMap;

    public java_09018_SessionManager_A08() {
        sessionMap = new HashMap<>();
        sessionIdMap = new HashMap<>();
    }

    // Method to start a session
    public String startSession() {
        String sessionId = UUID.randomUUID().toString(); // Generate a unique ID for the session
        Session session = new Session(); // Create a new session
        sessionMap.put(sessionId, session); // Add the session to the map
        sessionIdMap.put(session.getId(), sessionId); // Add the session ID to the map
        return sessionId; // Return the session ID
    }

    // Method to get a session
    public Session getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null;
        }
    }

    // Method to end a session
    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            Session session = sessionMap.get(sessionId);
            sessionMap.remove(sessionId);
            sessionIdMap.remove(session.getId());
        }
    }

    // Session class for holding session data
    private class Session {
        private String id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}