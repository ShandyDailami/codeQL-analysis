import java.util.HashMap;

public class java_23746_SessionManager_A07 {
    // Define a HashMap to store sessions
    private HashMap<String, String> sessionMap;

    // SessionManager constructor
    public java_23746_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String username) {
        // Generate a session ID
        String sessionID = String.valueOf(System.currentTimeMillis());

        // Store the session ID and username in the session map
        sessionMap.put(sessionID, username);

        // Return the session ID
        return sessionID;
    }

    // Method to validate a session
    public String validateSession(String sessionID) {
        // Check if the session ID exists in the session map
        if (sessionMap.containsKey(sessionID)) {
            // Return the username associated with the session ID
            return sessionMap.get(sessionID);
        } else {
            // Return null if the session ID does not exist
            return null;
        }
    }

    // Method to end a session
    public void endSession(String sessionID) {
        // Remove the session ID from the session map
        sessionMap.remove(sessionID);
    }
}