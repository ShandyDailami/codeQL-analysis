import java.util.HashMap;
import java.util.Map;

public class java_41303_SessionManager_A08 {
    private Map<String, String> sessions;

    public java_41303_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public void startSession(String username) {
        if (sessions.containsKey(username)) {
            throw new IllegalStateException("Session already exists for user " + username);
        }
        String sessionId = generateSessionId(username);
        sessions.put(sessionId, username);
    }

    public void endSession(String username) {
        if (!sessions.containsValue(username)) {
            throw new IllegalStateException("No session found for user " + username);
        }
        String sessionId = getSessionIdByUsername(username);
        sessions.remove(sessionId);
    }

    public String getUsernameBySessionId(String sessionId) {
        return sessions.get(sessionId);
    }

    // This method is used to generate a session ID. In a real-world example, this would involve hashing and salt generation.
    private String generateSessionId(String username) {
        // Simple implementation for demonstration purposes
        return "session_id_" + username;
    }

    // This method is used to get the session ID based on the username. In a real-world example, this would involve hashing and comparison.
    private String getSessionIdByUsername(String username) {
        // Simple implementation for demonstration purposes
        return "session_id_" + username;
    }
}