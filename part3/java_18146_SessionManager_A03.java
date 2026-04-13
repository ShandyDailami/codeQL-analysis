import java.util.HashMap;
import java.util.Map;

public class java_18146_SessionManager_A03 {
    private Map<String, Object> sessionMap;

    public java_18146_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId) {
        sessionMap.put(sessionId, new Object());
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void setAttribute(String sessionId, String attributeId, Object attributeValue) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, attributeValue);
        } else {
            throw new IllegalArgumentException("Session not found");
        }
    }

    public Object getAttribute(String sessionId, String attributeId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new IllegalArgumentException("Session not found");
        }
    }
}