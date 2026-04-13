import java.util.HashMap;
import java.util.Map;

public class java_19817_SessionManager_A01 {

    // A map to store session data
    private Map<String, String> sessionData;

    // Constructor
    public java_19817_SessionManager_A01() {
        this.sessionData = new HashMap<>();
    }

    // Method to start a session
    public String startSession(String username) {
        // Generate a unique session ID and store it in the session data
        String sessionID = generateSessionID(username);
        this.sessionData.put(sessionID, username);

        return sessionID;
    }

    // Method to validate a session
    public boolean validateSession(String sessionID) {
        // Check if the session ID is valid and in the session data
        return this.sessionData.containsKey(sessionID);
    }

    // Method to end a session
    public void endSession(String sessionID) {
        // Remove the session ID from the session data
        this.sessionData.remove(sessionID);
    }

    // Method to get user name from a session
    public String getUserName(String sessionID) {
        // Check if the session ID is valid and in the session data
        if(validateSession(sessionID)) {
            // Return the user name
            return this.sessionData.get(sessionID);
        } else {
            // If session is not valid, return null
            return null;
        }
    }

    // Method to generate a unique session ID
    private String generateSessionID(String username) {
        // This method should return a secure unique session ID based on username
        // For example, you can use a hash function to generate a hash and append the username to it
        // For simplicity, here we just return a simple string
        return username;
    }

}