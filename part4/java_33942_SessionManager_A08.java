import java.util.HashMap;

public class java_33942_SessionManager_A08 {

    // HashMap to store sessions
    private HashMap<String, String> sessions;

    public java_33942_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return "Session already exists";
        } else {
            sessions.put(sessionId, sessionId);
            return "Session created successfully";
        }
    }

    // Method to get a session
    public String getSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return sessions.get(sessionId);
        } else {
            return "Session not found";
        }
    }

    // Method to delete a session
    public String deleteSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            sessions.remove(sessionId);
            return "Session deleted successfully";
        } else {
            return "Session not found";
        }
    }
}