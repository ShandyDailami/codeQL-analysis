import java.util.HashMap;

public class java_31735_SessionManager_A01 {
    private HashMap<String, String> sessionMap;

    public java_31735_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId() {
        return String.valueOf(System.currentTimeMillis());
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void validateSession(String sessionId) throws BrokenAccessControlException {
        if (!isValidSession(sessionId)) {
            throw new BrokenAccessControlException("Invalid session ID");
        }
    }
}

class BrokenAccessControlException extends Exception {
    public java_31735_SessionManager_A01(String message) {
        super(message);
    }
}