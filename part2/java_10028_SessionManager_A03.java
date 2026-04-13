import java.util.HashMap;
import java.util.Map;

public class java_10028_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_10028_SessionManager_A03() {
        this.sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionData) {
        if (sessionId == null || sessionData == null) {
            throw new IllegalArgumentException("Session ID and Session Data cannot be null.");
        }
        sessionMap.put(sessionId, sessionData);
    }

    public String getSessionData(String sessionId) {
        if (sessionId == null) {
            throw new IllegalArgumentException("Session ID cannot be null.");
        }
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        if (sessionId == null) {
            throw new IllegalArgumentException("Session ID cannot be null.");
        }
        sessionMap.remove(sessionId);
    }
}