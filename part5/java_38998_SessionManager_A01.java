import java.util.HashMap;

public class java_38998_SessionManager_A01 {

    // Create a HashMap to store sessions
    private HashMap<String, String> sessions;

    // Constructor
    public java_38998_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String sessionId) {
        sessions.put(sessionId, sessionId);
        return sessionId;
    }

    // Method to validate a session
    public String validateSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return sessions.get(sessionId);
        } else {
            return "Invalid session ID";
        }
    }

    // Method to delete a session
    public String deleteSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            sessions.remove(sessionId);
            return "Session deleted";
        } else {
            return "Invalid session ID";
        }
    }
}