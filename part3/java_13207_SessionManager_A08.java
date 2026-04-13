import java.util.HashMap;

public class java_13207_SessionManager_A08 {

    // Create a new HashMap to store session data
    private HashMap<String, String> sessionData;

    // Constructor
    public java_13207_SessionManager_A08() {
        sessionData = new HashMap<String, String>();
    }

    // Method to start a session
    public String startSession(String userID) {
        // Generate a unique session ID
        String sessionID = Integer.toString(sessionData.size() + 1);

        // Store the session ID and user ID in the session data
        sessionData.put(sessionID, userID);

        // Return the session ID
        return sessionID;
    }

    // Method to end a session
    public void endSession(String sessionID) {
        // Remove the session data
        sessionData.remove(sessionID);
    }

    // Method to get the user ID for a session
    public String getUserID(String sessionID) {
        // Return the user ID associated with the session ID
        return sessionData.get(sessionID);
    }
}