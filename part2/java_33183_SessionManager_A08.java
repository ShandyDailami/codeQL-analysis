import java.util.HashMap;

public class java_33183_SessionManager_A08 {
    // Map to hold session data
    private HashMap<String, String> sessionData;

    // Constructor
    public java_33183_SessionManager_A08() {
        this.sessionData = new HashMap<>();
    }

    // Method to add a session
    public void addSession(String sessionID, String userID) {
        // Check for invalid session ID
        if (sessionID == null || sessionID.isEmpty()) {
            System.out.println("Invalid session ID.");
            return;
        }

        // Check for invalid user ID
        if (userID == null || userID.isEmpty()) {
            System.out.println("Invalid user ID.");
            return;
        }

        // Add session to data map
        sessionData.put(sessionID, userID);
    }

    // Method to remove a session
    public void removeSession(String sessionID) {
        // Check for invalid session ID
        if (sessionID == null || sessionID.isEmpty()) {
            System.out.println("Invalid session ID.");
            return;
        }

        // Remove session from data map
        sessionData.remove(sessionID);
    }

    // Method to get user ID from a session
    public String getUserIDFromSession(String sessionID) {
        // Check for invalid session ID
        if (sessionID == null || sessionID.isEmpty()) {
            System.out.println("Invalid session ID.");
            return null;
        }

        // Return user ID from data map
        return sessionData.get(sessionID);
    }

    // Method to check if a session is valid
    public boolean isValidSession(String sessionID) {
        // Check for invalid session ID
        if (sessionID == null || sessionID.isEmpty()) {
            System.out.println("Invalid session ID.");
            return false;
        }

        // Check if session is valid in data map
        return sessionData.containsKey(sessionID);
    }
}