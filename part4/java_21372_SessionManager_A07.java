import java.util.HashMap;
import java.util.Map;

public class java_21372_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_21372_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String userId, String sessionId) {
        sessionMap.put(userId, sessionId);
    }

    public String getSession(String userId) {
        return sessionMap.get(userId);
    }

    public void endSession(String userId) {
        sessionMap.remove(userId);
    }

    public void checkSessionExpiry(String userId) {
        String sessionId = sessionMap.get(userId);
        if (sessionId == null) {
            System.out.println("Session not found for user: " + userId);
            return;
        }

        // Assume sessionId is already validated
        System.out.println("Session found for user: " + userId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.createSession("user1", "session1");
        sessionManager.createSession("user2", "session2");

        sessionManager.checkSessionExpiry("user1");
        sessionManager.checkSessionExpiry("user3");

        sessionManager.endSession("user1");
        sessionManager.endSession("user2");
    }
}