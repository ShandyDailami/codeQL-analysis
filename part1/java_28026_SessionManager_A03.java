import java.util.HashMap;

public class java_28026_SessionManager_A03 {
    // HashMap to store sessions
    private HashMap<String, String> sessions;

    public java_28026_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return "Session already exists with the id: " + sessionId;
        } else {
            sessions.put(sessionId, sessionId);
            return "Session created with the id: " + sessionId;
        }
    }

    // Method to get a session
    public String getSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return "Session exists with the id: " + sessionId;
        } else {
            return "Session does not exist with the id: " + sessionId;
        }
    }

    // Method to delete a session
    public String deleteSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            sessions.remove(sessionId);
            return "Session deleted with the id: " + sessionId;
        } else {
            return "Session does not exist with the id: " + sessionId;
        }
    }
}