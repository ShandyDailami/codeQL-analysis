import java.util.HashMap;
import java.util.Map;

public class java_37913_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_37913_SessionManager_A08() {
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

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Create a session
        sessionManager.createSession("session1", "user1");

        // Get the user ID for a session
        String userId = sessionManager.getUserId("session1");
        System.out.println("User ID: " + userId); // Output: User ID: user1

        // Delete a session
        sessionManager.deleteSession("session1");

        // Check if a session exists
        String userId2 = sessionManager.getUserId("session1");
        System.out.println("User ID after deletion: " + userId2); // Output: User ID after deletion: null
    }
}