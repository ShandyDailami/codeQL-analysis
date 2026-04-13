import java.util.HashMap;
import java.util.Map;

public class java_20283_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_20283_SessionManager_A07() {
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

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Create a session
        String sessionId = "1234";
        String userId = "user1";
        sessionManager.createSession(sessionId, userId);

        // Validate the session
        if (sessionManager.isValidSession(sessionId)) {
            System.out.println("User ID: " + sessionManager.getUserId(sessionId));
        } else {
            System.out.println("Invalid session");
        }

        // Delete the session
        sessionManager.deleteSession(sessionId);
        if (!sessionManager.isValidSession(sessionId)) {
            System.out.println("Session deleted successfully");
        } else {
            System.out.println("Session still exists");
        }
    }
}