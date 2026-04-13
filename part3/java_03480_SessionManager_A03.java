import java.util.HashMap;
import java.util.Map;

public class java_03480_SessionManager_A03 {

    // Store sessions in a HashMap
    private Map<String, String> sessions;

    public java_03480_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            throw new RuntimeException("Session with ID " + sessionId + " already exists.");
        }
        sessions.put(sessionId, sessionId);
        return "Session created with ID " + sessionId;
    }

    // Method to retrieve a session
    public String getSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            throw new RuntimeException("Session with ID " + sessionId + " does not exist.");
        }
        return sessions.get(sessionId);
    }

    // Method to delete a session
    public String deleteSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            throw new RuntimeException("Session with ID " + sessionId + " does not exist.");
        }
        sessions.remove(sessionId);
        return "Session with ID " + sessionId + " deleted";
    }
}