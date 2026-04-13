import java.util.HashMap;

public class java_18500_SessionManager_A01 {
    private HashMap<String, String> sessionMap;

    public java_18500_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserIdFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Add your other methods here...
}