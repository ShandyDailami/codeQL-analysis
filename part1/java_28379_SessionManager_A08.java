import java.util.HashMap;
import java.util.Map;

public class java_28379_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_28379_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void addSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Adding sessions
        sessionManager.addSession("session1", "user1");
        sessionManager.addSession("session2", "user2");

        // Getting user id from session
        String userId = sessionManager.getUserId("session1");
        System.out.println("User ID: " + userId);

        // Removing session
        sessionManager.removeSession("session1");
    }
}