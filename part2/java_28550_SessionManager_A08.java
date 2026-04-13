import java.util.HashMap;

public class java_28550_SessionManager_A08 {
    // Using HashMap as the underlying data structure.
    private HashMap<String, String> sessionMap;

    // Constructor.
    public java_28550_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session.
    public String createSession(String sessionId) {
        // Checking if sessionId is already exists.
        if (sessionMap.containsKey(sessionId)) {
            return "Session already exists.";
        }

        // Adding session to the map.
        sessionMap.put(sessionId, "Active");
        return "Session created successfully.";
    }

    // Method to validate a session.
    public String validateSession(String sessionId) {
        // Checking if sessionId exists.
        if (!sessionMap.containsKey(sessionId)) {
            return "Session does not exist.";
        }

        // Checking if session is active.
        if ("Inactive".equals(sessionMap.get(sessionId))) {
            return "Session is inactive.";
        }

        return "Session is active.";
    }

    // Method to destroy a session.
    public String destroySession(String sessionId) {
        // Checking if sessionId exists.
        if (!sessionMap.containsKey(sessionId)) {
            return "Session does not exist.";
        }

        // Updating session status to inactive.
        sessionMap.replace(sessionId, "Inactive");
        return "Session destroyed successfully.";
    }
}