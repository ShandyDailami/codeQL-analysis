import java.util.HashMap;

public class java_09252_SessionManager_A01 {
    private HashMap<String, String> sessions;

    public java_09252_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = userId + System.currentTimeMillis(); // Create a session ID based on user ID and current time
        sessions.put(sessionId, userId); // Add user ID to sessions map
        return sessionId;
    }

    public String getUserFromSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessions.remove(sessionId);
    }
}