import java.util.HashMap;
import java.util.Map;

public class java_16508_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_16508_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            throw new SessionNotFoundException("Session not found: " + sessionId);
        }
    }

    public String getUserId(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new SessionNotFoundException("Session not found: " + sessionId);
        }
    }

    public static class SessionNotFoundException extends RuntimeException {
        public java_16508_SessionManager_A08(String message) {
            super(message);
        }
    }
}