import java.util.HashMap;
import java.util.Map;

public class java_29649_SessionManager_A07 {
    // Create a private Map to store session data
    private Map<String, String> sessionMap = new HashMap<>();

    // Method to create a session
    public String createSession(String userID) {
        // Generate a session ID
        String sessionID = generateSessionID();

        // Store the session ID and user ID in the session map
        sessionMap.put(sessionID, userID);

        return sessionID;
    }

    // Method to validate a session
    public boolean validateSession(String sessionID) {
        // Check if the session map contains the session ID
        if (sessionMap.containsKey(sessionID)) {
            // Validate the session by checking the user ID
            String userID = sessionMap.get(sessionID);

            // For simplicity, check if the user ID matches with the session ID
            if (userID.equals(sessionID)) {
                return true;
            }
        }

        return false;
    }

    // Helper method to generate a session ID
    private String generateSessionID() {
        // Here you can add your own logic for generating session IDs
        // For simplicity, we'll just generate a random ID
        return String.valueOf((int) (Math.random() * 1000000));
    }

    // For testing only
    public static void main(String[] args) {
        LegacySessionManager sessionManager = new LegacySessionManager();

        String sessionID = sessionManager.createSession("testUser");
        System.out.println("Created session: " + sessionID);

        boolean isValid = sessionManager.validateSession(sessionID);
        System.out.println("Session is valid: " + isValid);
    }
}