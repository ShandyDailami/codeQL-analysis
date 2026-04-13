import java.util.HashMap;

public class java_15749_SessionManager_A08 {
    private HashMap<String, String> sessionMap;

    public java_15749_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // This method is a security-sensitive operation related to integrity failure.
    // If the session does not exist, it throws an exception.
    public String getUserIdWithCheck(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new SecurityException("Session integrity failure: Session does not exist.");
        }
        return sessionMap.get(sessionId);
    }
}