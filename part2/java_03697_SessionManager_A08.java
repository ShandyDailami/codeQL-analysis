import java.util.HashMap;
import java.util.Map;

public class java_03697_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_03697_SessionManager_A08() {
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
        String sessionId = "session1";
        String userId = "user1";
        sessionManager.createSession(sessionId, userId);

        // Get the user ID from the session
        String user = sessionManager.getUserId(sessionId);
        System.out.println("User ID from session: " + user);

        // Delete the session
        sessionManager.deleteSession(sessionId);
    }
}