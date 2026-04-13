import java.util.HashMap;
import java.util.Map;

public class java_30282_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_30282_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String username, String sessionId) {
        sessionMap.put(sessionId, username);
    }

    public String getUsername(String sessionId) {
        return sessionMap.getOrDefault(sessionId, null);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Create a session
        String username = "alice";
        String sessionId = "123";
        sessionManager.createSession(username, sessionId);

        // Get the username from the session
        String fetchedUsername = sessionManager.getUsername(sessionId);
        System.out.println("Fetched username: " + fetchedUsername); // Output: Fetched username: alice

        // Delete the session
        sessionManager.deleteSession(sessionId);

        // Check if the session was deleted
        String deletedUsername = sessionManager.getUsername(sessionId);
        System.out.println("Deleted username: " + deletedUsername); // Output: Deleted username: null
    }
}