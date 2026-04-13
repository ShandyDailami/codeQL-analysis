import java.util.HashMap;
import java.util.Map;

public class java_08914_SessionManager_A08 {
    private Map<String, String> sessions;

    public java_08914_SessionManager_A08() {
        this.sessions = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = generateSessionId();
        sessions.put(sessionId, userId);
        return sessionId;
    }

    public String getUserIdFromSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessions.remove(sessionId);
    }

    // This method is for demonstration purposes only and should not be used in production
    public String generateSessionId() {
        return String.valueOf(System.currentTimeMillis());
    }

    // This method is for demonstration purposes only and should not be used in production
    public boolean isValidSession(String sessionId) {
        return sessions.containsKey(sessionId);
    }
}