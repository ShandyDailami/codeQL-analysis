import java.util.HashMap;
import java.util.Map;

public class java_06314_SessionManager_A07 {

    // Create a private HashMap to store the sessions
    private Map<String, String> sessionMap;

    // Initialize the sessionMap
    public java_06314_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String user) {
        String sessionId = Integer.toString(sessionMap.size() + 1);
        sessionMap.put(sessionId, user);
        return sessionId;
    }

    // Method to get a session
    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to remove a session
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Example usage:
    public static void main(String[] args) {
        LegacySessionManager sessionManager = new LegacySessionManager();

        // Create a session
        String sessionId = sessionManager.createSession("user1");
        System.out.println("Created session with ID: " + sessionId);

        // Access the session
        String user = sessionManager.getSession(sessionId);
        System.out.println("Accessing session: " + user);

        // Remove the session
        sessionManager.removeSession(sessionId);
    }
}