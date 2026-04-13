import java.util.HashMap;
import java.util.Map;

public class java_26310_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_26310_SessionManager_A08() {
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

        // Create a session for user1
        sessionManager.createSession("session1", "user1");

        // Get the userId associated with the session
        String userId = sessionManager.getUserId("session1");
        System.out.println("User ID: " + userId);

        // Delete the session
        sessionManager.deleteSession("session1");
    }
}