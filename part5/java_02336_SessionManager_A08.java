import java.util.HashMap;

public class java_02336_SessionManager_A08 {
    private HashMap<String, String> sessionMap;

    public java_02336_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String userId, String sessionId) {
        sessionMap.put(userId, sessionId);
    }

    public String getSession(String userId) {
        return sessionMap.get(userId);
    }

    public void deleteSession(String userId) {
        sessionMap.remove(userId);
    }
}

// Test SessionManager
public class TestSessionManager {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Create session
        sessionManager.createSession("user1", "session1");

        // Get session
        String session = sessionManager.getSession("user1");
        System.out.println("Session: " + session); // Expected output: Session: session1

        // Delete session
        sessionManager.deleteSession("user1");
        session = sessionManager.getSession("user1");
        System.out.println("Session: " + session); // Expected output: Session: null
    }
}