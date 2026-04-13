import java.util.HashMap;
import java.util.Map;

public class java_24379_SessionManager_A01 {
    // A map to store session information
    private Map<String, String> sessionMap;

    // Constructor
    public java_24379_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String sessionId) {
        // Validate sessionId
        if (sessionMap.containsKey(sessionId)) {
            return "Error: Session with id " + sessionId + " already exists.";
        }

        // Set session information
        sessionMap.put(sessionId, "Valid Session");
        return "Success: Session with id " + sessionId + " created.";
    }

    // Method to validate a session
    public String validateSession(String sessionId) {
        // Validate sessionId
        if (!sessionMap.containsKey(sessionId)) {
            return "Error: Session with id " + sessionId + " does not exist.";
        }

        // Check session information
        if (!sessionMap.get(sessionId).equals("Valid Session")) {
            return "Error: Session with id " + sessionId + " is not valid.";
        }

        return "Success: Session with id " + sessionId + " is valid.";
    }

    // Method to destroy a session
    public String destroySession(String sessionId) {
        // Validate sessionId
        if (!sessionMap.containsKey(sessionId)) {
            return "Error: Session with id " + sessionId + " does not exist.";
        }

        // Remove session information
        sessionMap.remove(sessionId);
        return "Success: Session with id " + sessionId + " destroyed.";
    }
}