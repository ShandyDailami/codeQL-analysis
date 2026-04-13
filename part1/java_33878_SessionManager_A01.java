import java.util.HashMap;

public class java_33878_SessionManager_A01 {
    private HashMap<String, String> sessionMap;

    public java_33878_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserIdFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isSessionValid(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Create a session
        sessionManager.createSession("session1", "user1");

        // Validate the session
        if (sessionManager.isSessionValid("session1")) {
            // Get user ID from the session
            String userId = sessionManager.getUserIdFromSession("session1");
            System.out.println("User ID: " + userId);
        }

        // Remove the session
        sessionManager.removeSession("session1");
    }
}