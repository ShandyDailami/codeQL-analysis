import java.util.HashMap;
import java.util.Map;

public class java_05168_SessionManager_A08 {

    private Map<String, String> sessionMap;

    public java_05168_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String value) {
        if (sessionId == null || sessionId.trim().isEmpty()) {
            throw new IllegalArgumentException("Session ID can not be null or empty");
        }
        if (value == null) {
            throw new IllegalArgumentException("Value can not be null");
        }
        sessionMap.put(sessionId, value);
    }

    public String getValue(String sessionId) {
        if (sessionId == null || sessionId.trim().isEmpty()) {
            throw new IllegalArgumentException("Session ID can not be null or empty");
        }
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        if (sessionId == null || sessionId.trim().isEmpty()) {
            throw new IllegalArgumentException("Session ID can not be null or empty");
        }
        sessionMap.remove(sessionId);
    }

    public void updateSession(String sessionId, String newValue) {
        if (sessionId == null || sessionId.trim().isEmpty()) {
            throw new IllegalArgumentException("Session ID can not be null or empty");
        }
        if (newValue == null) {
            throw new IllegalArgumentException("New value can not be null");
        }
        sessionMap.put(sessionId, newValue);
    }
}