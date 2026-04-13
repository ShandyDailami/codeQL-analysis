import java.util.HashMap;
import java.util.Map;

public class java_01980_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_01980_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = userId + System.currentTimeMillis();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Create a session
        String sessionId = sessionManager.createSession("user1");
        System.out.println("Created session: " + sessionId);

        // Get the user ID from the session
        String userId = sessionManager.getUserId(sessionId);
        System.out.println("User ID from session: " + userId);

        // Delete the session
        sessionManager.deleteSession(sessionId);
        System.out.println("Deleted session: " + sessionId);
    }
}