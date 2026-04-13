import java.util.HashMap;
import java.util.Map;

public class java_05988_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_05988_SessionManager_A01() {
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

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void checkSession(String sessionId) throws BrokenAccessControlException {
        if (!sessionMap.containsKey(sessionId)) {
            throw new BrokenAccessControlException("Session not found!");
        }
    }
}

class BrokenAccessControlException extends Exception {
    public java_05988_SessionManager_A01(String message) {
        super(message);
    }
}