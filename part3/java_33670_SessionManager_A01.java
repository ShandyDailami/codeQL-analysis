import java.util.HashMap;
import java.util.Map;

public class java_33670_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_33670_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void clearAllSessions() {
        sessionMap.clear();
    }

    public boolean isSessionExists(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        // Create a session
        manager.createSession("session1", "user1");

        // Get user from the session
        String user = manager.getUserFromSession("session1");
        System.out.println("User: " + user);

        // Delete the session
        manager.deleteSession("session1");

        // Check if the session exists
        boolean exists = manager.isSessionExists("session1");
        System.out.println("Session Exists: " + exists);

        // Clear all sessions
        manager.clearAllSessions();
    }
}