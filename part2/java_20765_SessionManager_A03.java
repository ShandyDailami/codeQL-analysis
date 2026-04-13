import java.util.HashMap;

public class java_20765_SessionManager_A03 {
    // Map to hold user sessions
    private HashMap<String, String> sessionMap;

    // Constructor
    public java_20765_SessionManager_A03() {
        this.sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String userID) {
        // Creates a random session ID
        String sessionID = userID + System.currentTimeMillis();

        // Store the session ID and user ID in the session map
        sessionMap.put(sessionID, userID);

        // Returns the session ID
        return sessionID;
    }

    // Method to validate a session
    public boolean validateSession(String sessionID) {
        // Checks if the session ID is in the session map
        return sessionMap.containsKey(sessionID);
    }

    // Method to get the user ID from a session
    public String getUserIDFromSession(String sessionID) {
        // Checks if the session ID is in the session map
        if(validateSession(sessionID)) {
            // Returns the user ID from the session map
            return sessionMap.get(sessionID);
        } else {
            // Returns null if the session ID is not in the session map
            return null;
        }
    }

    // Method to end a session
    public void endSession(String sessionID) {
        // Removes the session ID from the session map
        sessionMap.remove(sessionID);
    }
}