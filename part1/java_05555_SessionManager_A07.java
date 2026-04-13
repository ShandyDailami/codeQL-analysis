import java.util.HashMap;
import java.util.Map;

public class java_05555_SessionManager_A07 {
    private Map<String, String> sessions;

    public java_05555_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = "A07_" + userId;
        sessions.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessions.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessions.containsKey(sessionId);
    }
}