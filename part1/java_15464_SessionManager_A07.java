import java.util.HashMap;
import java.util.Map;

public class java_15464_SessionManager_A07 {
    // Session ID and User ID mapping
    private Map<String, String> sessionToUserMap;

    // Session ID and User ID mapping
    private Map<String, String> userToSessionMap;

    public java_15464_SessionManager_A07() {
        this.sessionToUserMap = new HashMap<>();
        this.userToSessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String userID) {
        // Generate a unique session ID
        String sessionID = generateSessionID();

        // Store the session-user mapping
        this.sessionToUserMap.put(sessionID, userID);
        this.userToSessionMap.put(userID, sessionID);

        return sessionID;
    }

    // Method to end a session
    public void endSession(String sessionID) {
        // Find the user associated with the session
        String userID = this.sessionToUserMap.get(sessionID);

        // Remove the session-user mapping
        this.sessionToUserMap.remove(sessionID);
        this.userToSessionMap.remove(userID);
    }

    // Method to get the user associated with a session
    public String getUserForSession(String sessionID) {
        return this.sessionToUserMap.get(sessionID);
    }

    // Generate a unique session ID
    private String generateSessionID() {
        // In a real-world application, this could be a UUID or a similar unique identifier
        return String.valueOf(System.currentTimeMillis());
    }
}