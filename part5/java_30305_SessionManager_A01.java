import java.util.HashMap;

public class java_30305_SessionManager_A01 {
    private HashMap<String, String> sessionMap;

    public java_30305_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = userId + System.currentTimeMillis(); // Assuming unique session for each user
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}