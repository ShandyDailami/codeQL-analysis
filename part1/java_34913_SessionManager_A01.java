import java.util.HashMap;
import java.util.Map;

public class java_34913_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_34913_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String userId, String sessionId) {
        sessionMap.put(userId, sessionId);
    }

    public String getSession(String userId) {
        return sessionMap.get(userId);
    }

    public void destroySession(String userId) {
        sessionMap.remove(userId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Create a session
        sessionManager.createSession("user1", "session1");

        // Get the session
        String session = sessionManager.getSession("user1");
        System.out.println("Session: " + session);

        // Destroy the session
        sessionManager.destroySession("user1");

        // Try to get the session after destroy
        session = sessionManager.getSession("user1");
        System.out.println("Trying to get session after destroy: " + session);
    }
}