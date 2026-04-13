import java.util.HashMap;
import java.util.Map;

public class java_17544_SessionManager_A03 {
    private Map<String, String> sessionStorage;

    public java_17544_SessionManager_A03() {
        sessionStorage = new HashMap<>();
    }

    public String createSession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }
        sessionStorage.put(sessionId, "Session Data");
        return sessionId;
    }

    public String getSessionData(String sessionId) {
        if (sessionId == null || sessionId.isEmpty() || sessionStorage.get(sessionId) == null) {
            throw new IllegalArgumentException("Invalid session ID");
        }
        return sessionStorage.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty() || sessionStorage.get(sessionId) == null) {
            throw new IllegalArgumentException("Invalid session ID");
        }
        sessionStorage.remove(sessionId);
    }

    public void updateSessionData(String sessionId, String newData) {
        if (sessionId == null || sessionId.isEmpty() || sessionStorage.get(sessionId) == null) {
            throw new IllegalArgumentException("Invalid session ID");
        }
        sessionStorage.put(sessionId, newData);
    }
}