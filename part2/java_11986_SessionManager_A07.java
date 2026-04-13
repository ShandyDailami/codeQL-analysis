import java.util.HashMap;
import java.util.Map;

public class java_11986_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_11986_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Create a session
    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    // Validate a session
    public String validateSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // End a session
    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Create a session
        sessionManager.createSession("session1", "user1");

        // Validate a session
        String userId = sessionManager.validateSession("session1");
        System.out.println("User ID: " + userId);

        // End a session
        sessionManager.endSession("session1");
    }
}