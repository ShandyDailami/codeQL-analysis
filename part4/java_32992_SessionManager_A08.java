import java.util.HashMap;

public class java_32992_SessionManager_A08 {
    private HashMap<String, String> sessions;

    public java_32992_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String userId) {
        String sessionId = Integer.toString(sessions.size() + 1);
        sessions.put(sessionId, userId);
        return sessionId;
    }

    // Method to get the userId for a given sessionId
    public String getUserId(String sessionId) {
        return sessions.get(sessionId);
    }

    // Method to remove a session
    public void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }
}