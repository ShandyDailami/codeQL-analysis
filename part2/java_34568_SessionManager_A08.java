import java.util.HashMap;
import java.util.Map;

public class java_34568_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_34568_SessionManager_A08() {
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

        // Create a session
        String sessionId1 = "session1";
        String userId1 = "user1";
        sessionManager.createSession(sessionId1, userId1);

        // Get userId from the session
        String userId = sessionManager.getUserId(sessionId1);
        System.out.println("User ID: " + userId);

        // Delete the session
        sessionManager.deleteSession(sessionId1);
    }
}