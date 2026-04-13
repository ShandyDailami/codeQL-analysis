import java.util.HashMap;

public class java_26995_SessionManager_A08 {
    // Define a HashMap to hold sessions.
    private HashMap<String, String> sessionMap;

    // Constructor to initialize sessionMap.
    public java_26995_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Method to start a session.
    public String startSession(String sessionId) {
        // Check if sessionId is null or already exists.
        if (sessionId == null || sessionMap.containsKey(sessionId)) {
            return "Error: Session already exists or sessionId is null.";
        }

        // Add the sessionId to sessionMap.
        sessionMap.put(sessionId, "Active");

        return "Successfully started session with sessionId: " + sessionId;
    }

    // Method to end a session.
    public String endSession(String sessionId) {
        // Check if sessionId is null or doesn't exist in sessionMap.
        if (sessionId == null || !sessionMap.containsKey(sessionId)) {
            return "Error: No session exists or sessionId is null.";
        }

        // Remove the sessionId from sessionMap.
        sessionMap.remove(sessionId);

        return "Successfully ended session with sessionId: " + sessionId;
    }

    // Method to get the status of a session.
    public String getSessionStatus(String sessionId) {
        // Check if sessionId is null or doesn't exist in sessionMap.
        if (sessionId == null || !sessionMap.containsKey(sessionId)) {
            return "Error: No session exists or sessionId is null.";
        }

        // Return the status of the session.
        return sessionMap.get(sessionId);
    }
}