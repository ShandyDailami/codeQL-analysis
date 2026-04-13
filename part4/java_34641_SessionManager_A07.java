import java.util.HashMap;
import java.util.Map;

public class java_34641_SessionManager_A07 {
    // A map to store sessions
    private Map<String, String> sessionMap;

    public java_34641_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to add a new session
    public void addSession(String sessionId, String username) {
        sessionMap.put(sessionId, username);
    }

    // Method to check if a session exists
    public boolean checkSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    // Method to get the username from a session
    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to remove a session
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Add a new session
        sessionManager.addSession("session1", "user1");

        // Check if a session exists
        System.out.println(sessionManager.checkSession("session1")); // Should print: true

        // Get the username from a session
        System.out.println(sessionManager.getUsername("session1")); // Should print: user1

        // Remove a session
        sessionManager.removeSession("session1");

        // Check if a session exists after removal
        System.out.println(sessionManager.checkSession("session1")); // Should print: false
    }
}