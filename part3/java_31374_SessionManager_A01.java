import java.util.HashMap;
import java.util.Map;

public class java_31374_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_31374_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserIdBySessionId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Create a session
        sessionManager.createSession("session1", "user1");

        // Get the user ID associated with the session
        String userId = sessionManager.getUserIdBySessionId("session1");
        System.out.println("User ID: " + userId);

        // Delete the session
        sessionManager.deleteSession("session1");
    }
}