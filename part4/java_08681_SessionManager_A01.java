import java.util.HashMap;
import java.util.Map;

public class java_08681_SessionManager_A01 {
    // Private Map to store sessions
    private Map<String, String> sessionMap;

    // Constructor
    public java_08681_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method to add a new session
    public void addSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    // Method to verify if a session is valid
    public boolean isValidSession(String sessionId, String userId) {
        String storedUserId = sessionMap.get(sessionId);
        return storedUserId != null && storedUserId.equals(userId);
    }

    // Method to remove a session
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Add a session for user1
        sessionManager.addSession("session1", "user1");

        // Validate the session
        if (sessionManager.isValidSession("session1", "user1")) {
            System.out.println("Session is valid.");
        } else {
            System.out.println("Session is invalid.");
        }

        // Try to validate the session as user2
        if (sessionManager.isValidSession("session1", "user2")) {
            System.out.println("Session is valid as user2.");
        } else {
            System.out.println("Session is invalid as user2.");
        }

        // Remove the session
        sessionManager.removeSession("session1");

        // Validate the session after removal
        if (sessionManager.isValidSession("session1", "user1")) {
            System.out.println("Session is still valid after removal.");
        } else {
            System.out.println("Session is invalid after removal.");
        }
    }
}