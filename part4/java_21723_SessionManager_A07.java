import java.util.HashMap;

public class java_21723_SessionManager_A07 {
    private HashMap<String, String> sessions;

    public java_21723_SessionManager_A07() {
        this.sessions = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = generateSessionId();
        sessions.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessions.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessions.remove(sessionId);
    }

    // This method is a placeholder for authentication failure handling
    public boolean isValidSession(String sessionId) {
        return sessions.containsKey(sessionId);
    }

    private String generateSessionId() {
        return String.valueOf(System.currentTimeMillis());
    }
}