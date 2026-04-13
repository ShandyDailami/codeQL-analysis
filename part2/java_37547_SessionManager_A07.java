import java.util.HashMap;
import java.util.Map;

public class java_37547_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_37547_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId) {
        String sessionId = generateSessionId(userId);
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId(String userId) {
        // For security-sensitive operations related to A07_AuthFailure, generate a sessionId
        // You could use a UUID or other secure method
        return userId;
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        manager.startSession("user1");
        String sessionId = manager.getUserId("user1");
        System.out.println("Session ID: " + sessionId);

        manager.startSession("user2");
        sessionId = manager.getUserId("user2");
        System.out.println("Session ID: " + sessionId);

        manager.endSession("user1");
        sessionId = manager.getUserId("user1");
        System.out.println("Session ID: " + sessionId);
    }
}