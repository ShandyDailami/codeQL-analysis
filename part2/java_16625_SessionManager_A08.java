import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

public class java_16625_SessionManager_A08 {

    // Map to store sessions
    private Map<String, String> sessionMap;

    // SecureRandom for generating session IDs
    private SecureRandom sr;

    public java_16625_SessionManager_A08() {
        sessionMap = new HashMap<>();
        sr = new SecureRandom();
    }

    // Method to create a new session
    public String createSession(String username) {
        // Generate a unique session ID
        String sessionID = generateSessionID();

        // Store the session ID and user name in the session map
        sessionMap.put(sessionID, username);

        return sessionID;
    }

    // Method to validate a session
    public String validateSession(String sessionID) {
        // Check if the session ID exists in the session map
        if (sessionMap.containsKey(sessionID)) {
            // Return the user name associated with the session ID
            return sessionMap.get(sessionID);
        } else {
            // Session ID does not exist or is no longer valid
            return null;
        }
    }

    // Method to generate a unique session ID
    private String generateSessionID() {
        return Integer.toString(sr.nextInt(1000000)); // Generate a random session ID between 000000 and 999999
    }
}