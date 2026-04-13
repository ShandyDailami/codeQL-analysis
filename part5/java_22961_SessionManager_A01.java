import java.util.HashMap;
import java.util.Map;

public class java_22961_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_22961_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
        System.out.println("Session started with ID: " + sessionId + ", User ID: " + userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
        System.out.println("Session ended with ID: " + sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Start a new session for user A
        sessionManager.startSession("session1", "A");

        // Get the user ID of the session
        String userId = sessionManager.getUserId("session1");
        System.out.println("User ID: " + userId);

        // End the session
        sessionManager.endSession("session1");
    }
}