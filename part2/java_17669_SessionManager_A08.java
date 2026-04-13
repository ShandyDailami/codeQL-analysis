import java.util.HashMap;
import java.util.Map;

public class java_17669_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_17669_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        this.sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return this.sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        this.sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Create a session
        sessionManager.createSession("session1", "user1");

        // Get the user id for a session
        String userId = sessionManager.getUserId("session1");
        System.out.println("User ID: " + userId);

        // Delete a session
        sessionManager.deleteSession("session1");
    }
}