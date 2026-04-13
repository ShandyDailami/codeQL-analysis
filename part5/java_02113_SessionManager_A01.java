import java.util.HashMap;
import java.util.Map;

public class java_02113_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_02113_SessionManager_A01() {
        this.sessionMap = new HashMap<>();
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
        sessionManager.createSession("session1", "user1");

        // Get the user id from the session
        String userId = sessionManager.getUserId("session1");
        System.out.println("User ID: " + userId); // Should print: User ID: user1

        // Delete the session
        sessionManager.deleteSession("session1");
    }
}