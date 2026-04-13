import java.util.HashMap;
import java.util.Map;

public class java_06558_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_06558_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserIdBySessionId(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            System.out.println("Session not found.");
            return null;
        }
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Creating a new session
        sessionManager.createSession("session1", "user1");

        // Getting a user ID from a session ID
        String userId = sessionManager.getUserIdBySessionId("session1");
        System.out.println("User ID: " + userId);

        // Deleting a session
        sessionManager.deleteSession("session1");
    }
}