import java.util.HashMap;

public class java_26575_SessionManager_A03 {
    private HashMap<String, String> sessionMap;

    public java_26575_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserIdBySessionId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Add other session management methods as needed (e.g., updateSession, invalidateSession)
}