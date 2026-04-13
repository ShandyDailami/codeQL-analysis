import java.util.HashMap;

public class java_17472_SessionManager_A08 {
    // Create a HashMap to store sessions
    private HashMap<String, String> sessions = new HashMap<>();

    // Method to create a new session
    public String createSession(String user) {
        // Generate a unique session ID
        String sessionID = user + "_" + System.currentTimeMillis();
        // Store the session ID and user name in the HashMap
        sessions.put(sessionID, user);
        // Return the session ID
        return sessionID;
    }

    // Method to validate a session
    public String validateSession(String sessionID) {
        // Check if the session ID is in the HashMap
        if (sessions.containsKey(sessionID)) {
            // Return the user name associated with the session ID
            return sessions.get(sessionID);
        } else {
            // Return null if the session ID is not in the HashMap
            return null;
        }
    }

    // Method to destroy a session
    public void destroySession(String sessionID) {
        // Remove the session ID from the HashMap
        sessions.remove(sessionID);
    }
}