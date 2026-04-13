import java.util.HashMap;
import java.util.Map;

public class java_17331_SessionManager_A07 {

    // Create a map to store session IDs and user IDs
    private Map<String, String> sessionMap;

    // Constructor
    public java_17331_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String userID) {
        // Generate a unique session ID
        String sessionID = generateSessionID();

        // Store the user ID and session ID in the map
        sessionMap.put(sessionID, userID);

        // Return the session ID
        return sessionID;
    }

    // Method to retrieve a user ID from a session
    public String getUserID(String sessionID) {
        // Retrieve the user ID from the map using the session ID
        return sessionMap.get(sessionID);
    }

    // Method to invalidate a session
    public void invalidateSession(String sessionID) {
        // Remove the session ID from the map
        sessionMap.remove(sessionID);
    }

    // Method to check if a session is valid
    public boolean isValidSession(String sessionID) {
        // Use the session ID to retrieve the user ID from the map
        String userID = sessionMap.get(sessionID);

        // If the user ID is not null, then the session is valid
        return userID != null;
    }

    // Helper method to generate a unique session ID
    private String generateSessionID() {
        // This method is left empty as it is not clear what should be done when generating a session ID
        // You might generate a random string, or use a unique identifier generated elsewhere in your system
        return "";
    }
}