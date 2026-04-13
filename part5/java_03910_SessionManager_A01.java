import java.util.HashMap;
import java.util.Map;

public class java_03910_SessionManager_A01 {

    // A map to store sessions. The key is the session ID, and the value is the session object.
    private Map<String, Session> sessionMap;

    // A map to store session IDs. The key is the session ID, and the value is the user ID.
    private Map<String, String> sessionIdMap;

    public java_03910_SessionManager_A01() {
        sessionMap = new HashMap<>();
        sessionIdMap = new HashMap<>();
    }

    // Method to create a new session.
    public Session createSession(String userId) {
        // Generate a new session ID.
        String sessionId = generateSessionId();

        // Create a new session object.
        Session session = new Session(sessionId, userId);

        // Store the session object in the session map.
        sessionMap.put(sessionId, session);

        // Store the session ID in the session ID map.
        sessionIdMap.put(sessionId, userId);

        return session;
    }

    // Method to get a session given a session ID.
    public Session getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to check if a session ID is valid.
    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    // Method to check if a user ID is valid.
    public boolean isValidUser(String userId) {
        return sessionIdMap.containsValue(userId);
    }

    // Helper method to generate a new session ID.
    private String generateSessionId() {
        // Implement your own logic to generate a session ID here.
        // This is just a placeholder.
        return "SESSION_ID";
    }
}

class Session {
    private String id;
    private String userId;

    public java_03910_SessionManager_A01(String id, String userId) {
        this.id = id;
        this.userId = userId;
    }

    // Here you can add methods to manipulate the session, like changing user or invalidating the session.
}