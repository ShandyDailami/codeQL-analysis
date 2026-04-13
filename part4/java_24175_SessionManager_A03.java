import java.util.HashMap;
import java.util.Map;

public class java_24175_SessionManager_A03 {
    // Create a HashMap to store sessions
    private Map<String, Session> sessions;

    public java_24175_SessionManager_A03() {
        // Initialize the session map
        sessions = new HashMap<>();
    }

    // Method to create a new session
    public Session createSession(String sessionId) {
        // Create a new session object
        Session session = new Session(sessionId);
        // Add the session object to the map with the hash code of the session id as the key
        sessions.put(sessionId, session);
        return session;
    }

    // Method to get a session from the map
    public Session getSession(String sessionId) {
        // Get the session object from the map using the hash code of the session id as the key
        return sessions.get(sessionId);
    }
}