import java.util.HashMap;
import java.util.Map;

public class java_26181_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_26181_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserIdFromSession(String sessionId) throws SecurityFailureException {
        if (!sessionMap.containsKey(sessionId)) {
            throw new SecurityFailureException("Session not found!");
        }
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static class SecurityFailureException extends Exception {
        public java_26181_SessionManager_A08(String message) {
            super(message);
        }
    }
}