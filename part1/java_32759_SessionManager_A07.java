import java.util.HashMap;
import java.util.Map;

public class java_32759_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_32759_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = userId + System.currentTimeMillis();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void validateSession(String sessionId) throws SessionNotFoundException {
        if (!sessionMap.containsKey(sessionId)) {
            throw new SessionNotFoundException("Invalid session ID");
        }
    }

    public void closeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}

class SessionNotFoundException extends Exception {
    public java_32759_SessionManager_A07(String message) {
        super(message);
    }
}