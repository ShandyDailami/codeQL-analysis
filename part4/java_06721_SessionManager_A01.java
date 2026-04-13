import java.util.HashMap;
import java.util.Map;

public class java_06721_SessionManager_A01 {
    // A map to hold user sessions
    private Map<String, String> sessionMap;

    // Constructor
    public java_06721_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String username) {
        // Generate a session ID
        String sessionID = generateSessionID();

        // Store the username in the session map
        sessionMap.put(sessionID, username);

        return sessionID;
    }

    // Method to validate a session
    public boolean validateSession(String sessionID) {
        // Check if the session ID is in the session map
        return sessionMap.containsKey(sessionID);
    }

    // Method to get the username from a session
    public String getUsernameFromSession(String sessionID) {
        // Check if the session ID is valid
        if (validateSession(sessionID)) {
            // Return the username from the session map
            return sessionMap.get(sessionID);
        } else {
            throw new IllegalArgumentException("Invalid session ID");
        }
    }

    // Method to destroy a session
    public void destroySession(String sessionID) {
        // Check if the session ID is valid
        if (validateSession(sessionID)) {
            // Remove the session from the session map
            sessionMap.remove(sessionID);
        } else {
            throw new IllegalArgumentException("Invalid session ID");
        }
    }

    // Method to generate a session ID
    private String generateSessionID() {
        // This is a simple implementation, you should use a more secure method for real-world applications
        return String.valueOf(System.currentTimeMillis());
    }
}