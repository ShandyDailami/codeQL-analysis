import java.util.HashMap;
import java.util.Map;

public class java_40052_SessionManager_A07 {

    // Map to store sessions
    private Map<String, String> sessionMap;

    public java_40052_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Method to validate a session
    public String validateSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to destroy a session
    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();

        // Create a session
        String sessionId = sm.createSession("session1", "user1");
        System.out.println("Created session: " + sessionId);

        // Validate the session
        String userId = sm.validateSession("session1");
        System.out.println("Validated session: " + userId);

        // Destroy the session
        sm.destroySession("session1");
        System.out.println("Destroyed session: " + "session1");
    }
}