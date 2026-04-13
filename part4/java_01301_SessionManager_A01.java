import java.util.HashMap;
import java.util.Map;

public class java_01301_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_01301_SessionManager_A01() {
        this.sessionMap = new HashMap<>();
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

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Add a session
        sessionManager.addSession("session1", "user1");

        // Get user from a session
        System.out.println("User in session1: " + sessionManager.getUserId("session1"));

        // Validate a session
        System.out.println("Is session1 valid: " + sessionManager.isValidSession("session1"));

        // Remove a session
        sessionManager.removeSession("session1");

        // Validate a session (should be invalid)
        System.out.println("Is session1 valid after removal: " + sessionManager.isValidSession("session1"));
    }
}