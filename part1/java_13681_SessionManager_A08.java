import java.util.HashMap;
import java.util.Map;

public class java_13681_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_13681_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) throws IntegrityFailureException {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IntegrityFailureException("Invalid session Id");
        }
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public class IntegrityFailureException extends Exception {
        public java_13681_SessionManager_A08(String message) {
            super(message);
        }
    }
}