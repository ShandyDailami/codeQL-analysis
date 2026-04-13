import java.util.HashMap;
import java.util.Map;

public class java_25372_SessionManager_A03 {
    private Map<String, String> sessions;

    public java_25372_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionValue) {
        if (sessionId == null || sessionValue == null) {
            throw new IllegalArgumentException("Session ID and value must be provided");
        }

        sessions.put(sessionId, sessionValue);
    }

    public String getSessionValue(String sessionId) {
        if (sessionId == null) {
            throw new IllegalArgumentException("Session ID must be provided");
        }

        return sessions.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        if (sessionId == null) {
            throw new IllegalArgumentException("Session ID must be provided");
        }

        sessions.remove(sessionId);
    }
}