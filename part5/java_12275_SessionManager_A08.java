import java.util.HashMap;
import java.util.Map;

public class java_12275_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_12275_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String value) {
        sessionMap.put(sessionId, value);
    }

    public String getValue(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new IllegalArgumentException("Session not found!");
        }
    }

    public void deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            throw new IllegalArgumentException("Session not found!");
        }
    }

    public void updateSession(String sessionId, String value) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, value);
        } else {
            throw new IllegalArgumentException("Session not found!");
        }
    }
}