import java.util.HashMap;
import java.util.Map;

public class java_22047_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_22047_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        CustomSessionManager sessionManager = new CustomSessionManager();

        // Start a session
        sessionManager.startSession("session1", "user1");

        // Get user id for the session
        String userId = sessionManager.getUserId("session1");
        System.out.println("User ID: " + userId);

        // End the session
        sessionManager.endSession("session1");
    }
}