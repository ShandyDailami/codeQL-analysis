import java.util.HashMap;

public class java_23723_SessionManager_A03 {
    private HashMap<String, String> sessionMap;

    public java_23723_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Session creation
    public String createSession(String userId) {
        String sessionId = userId + System.currentTimeMillis();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Session retrieval
    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Session destruction
    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}