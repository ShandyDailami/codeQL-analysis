import java.util.HashMap;
import java.util.Map;

public class java_24776_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_24776_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId, String sessionValue) {
        if (sessionId == null || sessionValue == null) {
            throw new IllegalArgumentException("Session ID and session value must not be null");
        }
        sessionMap.put(sessionId, sessionValue);
        return sessionId;
    }

    public String getSessionValue(String sessionId) {
        if (sessionId == null) {
            throw new IllegalArgumentException("Session ID must not be null");
        }
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        if (sessionId == null) {
            throw new IllegalArgumentException("Session ID must not be null");
        }
        sessionMap.remove(sessionId);
    }

    public boolean sessionExists(String sessionId) {
        if (sessionId == null) {
            throw new IllegalArgumentException("Session ID must not be null");
        }
        return sessionMap.containsKey(sessionId);
    }
}