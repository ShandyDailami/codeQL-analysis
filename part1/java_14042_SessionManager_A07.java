import java.util.HashMap;
import java.util.Map;

public class java_14042_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_14042_SessionManager_A07() {
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
        SessionManager sessionManager = new SessionManager();

        // Start a session
        String sessionId = "session1";
        String userId = "user1";
        sessionManager.startSession(sessionId, userId);

        // Get the user ID from the session
        String user = sessionManager.getUserId(sessionId);
        System.out.println("User ID: " + user);

        // End the session
        sessionManager.endSession(sessionId);
    }
}