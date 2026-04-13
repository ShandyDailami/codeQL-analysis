import java.util.HashMap;

public class java_07474_SessionManager_A08 {
    private HashMap<String, String> sessionMap;

    public java_07474_SessionManager_A08() {
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

    // Assume this method is invoked when a session has been inactive for a certain period
    // This is a simplified example, not a full-fledged security-sensitive operation
    public void pruneInactiveSessions() {
        long currentTime = System.currentTimeMillis();

        for (String sessionId : sessionMap.keySet()) {
            long lastAccessedTime = Long.parseLong(sessionMap.get(sessionId));
            if ((currentTime - lastAccessedTime) > 10000) { // 10 seconds
                deleteSession(sessionId);
            }
        }
    }
}