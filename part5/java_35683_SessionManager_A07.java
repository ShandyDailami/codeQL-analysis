import java.util.HashMap;
import java.util.Map;

public class java_35683_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_35683_SessionManager_A07() {
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

    public boolean sessionExists(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Create a session for a user
        sessionManager.createSession("session1", "user1");

        // Get the user id for a session
        String userId = sessionManager.getUserId("session1");
        System.out.println("User ID: " + userId);

        // Delete a session
        sessionManager.deleteSession("session1");

        // Check if a session exists
        boolean sessionExists = sessionManager.sessionExists("session1");
        System.out.println("Session Exists: " + sessionExists);
    }
}