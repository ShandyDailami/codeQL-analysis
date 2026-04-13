import java.util.HashMap;
import java.util.Map;

public class java_30463_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_30463_SessionManager_A01() {
        this.sessionMap = new HashMap<>();
    }

    public void createSession(String userId, String sessionId) {
        sessionMap.put(userId, sessionId);
    }

    public String getSession(String userId) {
        return sessionMap.get(userId);
    }

    public void deleteSession(String userId) {
        sessionMap.remove(userId);
    }

    public boolean isValidSession(String userId, String sessionId) {
        return sessionMap.containsKey(userId) && sessionMap.get(userId).equals(sessionId);
    }

    public void cleanupExpiredSessions() {
        // This is a very simplified scenario. In a real-world scenario, you would need to consider time-to-live (TTL) and potentially also invalidate all sessions that have expired.
        // This example does not include that part, but it demonstrates the concept.
        sessionMap.entrySet().removeIf(entry -> entry.getValue() == null);
    }
}