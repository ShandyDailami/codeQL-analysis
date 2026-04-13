import java.util.HashMap;

public class java_36467_SessionManager_A07 {
    // Create a new HashMap to store session data
    private HashMap<String, String> sessionData;

    public java_36467_SessionManager_A07() {
        sessionData = new HashMap<>();
    }

    // Method to start a new session
    public String startSession(String userID) {
        // Generate a session key
        String sessionKey = generateSessionKey(userID);
        // Store userID as session data
        sessionData.put(sessionKey, userID);
        return sessionKey;
    }

    // Method to end a session
    public void endSession(String sessionKey) {
        // Remove session data
        sessionData.remove(sessionKey);
    }

    // Method to get the userID from a session key
    public String getUserID(String sessionKey) {
        // Return the userID from session data
        return sessionData.get(sessionKey);
    }

    // Method to validate if a session key exists
    public boolean validateSession(String sessionKey) {
        // Return true if session key is in session data, false otherwise
        return sessionData.containsKey(sessionKey);
    }

    // Helper method to generate a session key
    private String generateSessionKey(String userID) {
        // This is a simple hashing method, you may use a more secure method depending on your requirements
        return String.valueOf(userID.hashCode());
    }
}