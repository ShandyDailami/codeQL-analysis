import java.util.HashMap;

public class java_17427_SessionManager_A07 {
    // Create a hashmap to store session data
    private HashMap<String, String> sessionData = new HashMap<String, String>();

    // Method to create a new session
    public String createSession(String username) {
        // Generate a session ID and store it in the hashmap
        String sessionID = "SESSION_" + username;
        sessionData.put(sessionID, username);

        return sessionID;
    }

    // Method to validate a session
    public String validateSession(String sessionID) {
        // Check if the session ID exists in the hashmap
        if (sessionData.containsKey(sessionID)) {
            // Return the username associated with the session
            return sessionData.get(sessionID);
        } else {
            // Return null if the session ID does not exist
            return null;
        }
    }

    // Method to end a session
    public void endSession(String sessionID) {
        // Remove the session ID from the hashmap
        sessionData.remove(sessionID);
    }
}