import java.util.HashMap;

public class java_22677_SessionManager_A08 {
    // A HashMap to store sessions
    private HashMap<String, String> sessions;

    public java_22677_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String user) {
        String sessionId = String.valueOf(System.currentTimeMillis());
        sessions.put(sessionId, user);
        return sessionId;
    }

    // Method to validate a session
    public String validateSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return sessions.get(sessionId);
        }
        return null;
    }

    // Method to delete a session
    public void deleteSession(String sessionId) {
        sessions.remove(sessionId);
    }
}

// Test the SessionManager
public class Main {
    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        // Create a session
        String sessionId = manager.createSession("User1");
        System.out.println("Created session with ID: " + sessionId);

        // Validate the session
        String user = manager.validateSession(sessionId);
        System.out.println("Validated session for user: " + user);

        // Delete the session
        manager.deleteSession(sessionId);
    }
}