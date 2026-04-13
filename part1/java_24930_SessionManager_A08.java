import java.util.HashMap;
import java.util.Map;

public class java_24930_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_24930_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId) {
        if (!sessionMap.containsKey(userId)) {
            sessionMap.put(userId, createSessionId());
        } else {
            System.out.println("Session already exists for user: " + userId);
        }
    }

    public void endSession(String userId) {
        if (sessionMap.containsKey(userId)) {
            sessionMap.remove(userId);
        } else {
            System.out.println("No session exists for user: " + userId);
        }
    }

    private String createSessionId() {
        // Implementation for generating session ID
        // This is a placeholder and needs to be replaced with actual logic
        return "SessionID" + System.currentTimeMillis();
    }

    public String getSessionId(String userId) {
        if (sessionMap.containsKey(userId)) {
            return sessionMap.get(userId);
        } else {
            System.out.println("No session exists for user: " + userId);
            return null;
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.startSession("user1");
        sessionManager.startSession("user2");

        System.out.println("Session ID for user1: " + sessionManager.getSessionId("user1"));
        System.out.println("Session ID for user2: " + sessionManager.getSessionId("user2"));

        sessionManager.endSession("user1");
        sessionManager.endSession("user3");
    }
}