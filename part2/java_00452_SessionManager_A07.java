import java.util.HashMap;
import java.util.Map;

public class java_00452_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_00452_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Create a session
        sessionManager.createSession("session1", "user1");

        // Get the user ID associated with the session
        String userId = sessionManager.getUserId("session1");
        System.out.println("User ID: " + userId);

        // End the session
        sessionManager.endSession("session1");
    }
}