import java.util.HashMap;
import java.util.Map;

public class java_30506_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_30506_SessionManager_A01() {
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
        SessionManager manager = new SessionManager();

        // Create a session
        manager.createSession("session1", "user1");

        // Get the user from the session
        String userId = manager.getUserId("session1");
        System.out.println("User ID: " + userId); // Output: User ID: user1

        // Delete the session
        manager.deleteSession("session1");

        // Try to get the user from the session (Should return null)
        userId = manager.getUserId("session1");
        System.out.println("User ID: " + userId); // Output: User ID: null
    }
}