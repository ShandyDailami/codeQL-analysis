import java.util.HashMap;

public class java_14041_SessionManager_A07 {
    // A HashMap to store sessions
    private HashMap<String, String> sessionMap;

    // Constructor
    public java_14041_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String sessionID) {
        // Check if the session ID is already in use
        if (sessionMap.containsKey(sessionID)) {
            return "Error: Session ID already in use";
        }

        // If not in use, add the session ID to the map
        sessionMap.put(sessionID, "Session is active");
        return "Success: Session ID created";
    }

    // Method to validate a session
    public String validateSession(String sessionID) {
        // Check if the session ID is in the map
        if (!sessionMap.containsKey(sessionID)) {
            return "Error: Invalid session ID";
        }

        // If in the map, return a success message
        return "Success: Valid session ID";
    }

    // Method to end a session
    public String endSession(String sessionID) {
        // Check if the session ID is in the map
        if (!sessionMap.containsKey(sessionID)) {
            return "Error: Invalid session ID";
        }

        // If in the map, remove the session ID from the map
        sessionMap.remove(sessionID);
        return "Success: Session ID ended";
    }
}