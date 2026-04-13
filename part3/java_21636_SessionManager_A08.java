import java.util.HashMap;
import java.util.Map;

public class java_21636_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_21636_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserIdFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // The following methods are used for testing purposes.
    public Map<String, String> getSessionMap() {
        return sessionMap;
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.createSession("session1", "user1");
        String userId = sessionManager.getUserIdFromSession("session1");
        System.out.println("User ID: " + userId); // Output: User ID: user1

        sessionManager.deleteSession("session1");
        userId = sessionManager.getUserIdFromSession("session1");
        System.out.println("User ID: " + userId); // Output: User ID: null

        // Test integrity failure: attempting to get a non-existent session ID
        userId = sessionManager.getUserIdFromSession("nonexistentSession");
        System.out.println("User ID: " + userId); // Output: User ID: null
    }
}