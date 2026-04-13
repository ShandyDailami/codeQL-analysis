import java.util.HashMap;
import java.util.Map;

public class java_19519_SessionManager_A07 {

    // Create a map to store sessions
    private Map<String, String> sessionMap;

    public java_19519_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String userID) {
        String sessionID = UUID.randomUUID().toString();
        sessionMap.put(sessionID, userID);
        return sessionID;
    }

    // Method to validate a session
    public String validateSession(String sessionID) {
        String userID = sessionMap.get(sessionID);
        if (userID == null) {
            return "Invalid Session";
        }
        // Add security-sensitive operations here
        // For example, checking the user's access rights
        if (!isUserAllowedToAccess(userID)) {
            return "Access Denied";
        }
        return "Valid Session";
    }

    // Method to check if a user is allowed to access
    private boolean isUserAllowedToAccess(String userID) {
        // Implement security-sensitive operations here
        // For example, checking if the user is an admin
        return userID.equals("admin");
    }
}