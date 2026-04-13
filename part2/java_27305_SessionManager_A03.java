import java.util.HashMap;
import java.util.Map;

public class java_27305_SessionManager_A03 {

    private Map<String, Object> sessionMap;

    public java_27305_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, Object sessionObject) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }
        sessionMap.put(sessionId, sessionObject);
    }

    public Object getSession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }
        sessionMap.remove(sessionId);
    }
}