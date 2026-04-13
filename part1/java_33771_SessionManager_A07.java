import java.util.HashMap;
import java.util.Map;

public class java_33771_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_33771_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = UUID.randomUUID().toString(); // Generate a random session ID
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        String sessionId = sessionManager.createSession("user1");
        System.out.println("Session ID: " + sessionId);
        System.out.println("Username: " + sessionManager.getUsername(sessionId));

        // Modify the username
        sessionManager.createSession("user2");
        System.out.println("Session ID: " + sessionManager.createSession("user2"));

        // Destroy the session
        sessionManager.destroySession(sessionId);
    }
}