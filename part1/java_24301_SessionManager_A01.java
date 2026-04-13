import java.util.HashMap;

public class java_24301_SessionManager_A01 {
    // Create a HashMap to store sessions
    private HashMap<String, String> sessions;

    // Constructor
    public java_24301_SessionManager_A01() {
        this.sessions = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String sessionId) {
        // Check if sessionId is already used
        if (sessions.containsKey(sessionId)) {
            return "Error: Session ID already in use!";
        }

        // If sessionId is not used, add it to the HashMap
        sessions.put(sessionId, sessionId);

        return "Session created with ID: " + sessionId;
    }

    // Method to validate a session
    public String validateSession(String sessionId) {
        // Check if sessionId exists in the HashMap
        if (!sessions.containsKey(sessionId)) {
            return "Error: Session ID does not exist!";
        }

        // If sessionId exists in the HashMap, return a success message
        return "Session validation successful!";
    }
}