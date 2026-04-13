import java.util.HashMap;
import java.util.Map;

public class java_21651_SessionManager_A07 {
    // Map to store session data
    private Map<String, String> sessionMap;

    // Constructor
    public java_21651_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    // Method to add a session
    public void addSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    // Method to get the user for a given session
    public String getUserForSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to remove a session
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}

// Example usage
public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Add a session
        sessionManager.addSession("session1", "user1");

        // Get the user for a given session
        String user = sessionManager.getUserForSession("session1");
        System.out.println("User: " + user); // Output: User: user1

        // Remove a session
        sessionManager.removeSession("session1");
    }
}