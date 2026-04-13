import java.util.HashMap;
import java.util.Map;

public class java_23125_SessionManager_A07 {
    // A map to hold session IDs and user names.
    private Map<String, String> sessionMap;

    // Constructor.
    public java_23125_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session.
    public String createSession(String userName) {
        // Generate a random session ID.
        String sessionID = generateSessionID();

        // Store the session ID and user name in the map.
        sessionMap.put(sessionID, userName);

        return sessionID;
    }

    // Method to validate a session.
    public boolean validateSession(String sessionID) {
        // Check if the session ID is in the map.
        return sessionMap.containsKey(sessionID);
    }

    // Method to get the user name from a session.
    public String getUserName(String sessionID) {
        // Get the user name from the map.
        return sessionMap.get(sessionID);
    }

    // Method to end a session.
    public void endSession(String sessionID) {
        // Remove the session ID from the map.
        sessionMap.remove(sessionID);
    }

    // Helper method to generate a random session ID.
    private String generateSessionID() {
        // This is a simple example, in a real application you would probably use a UUID or some other unique identifier.
        return String.valueOf(System.currentTimeMillis());
    }
}