import java.util.HashMap;
import java.util.Map;

public class java_20188_SessionManager_A01 {

    // Create a HashMap to store sessions
    private Map<String, String> sessions;

    // Constructor
    public java_20188_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    // Method to start a session
    public void startSession(String username, String sessionId) {
        sessions.put(sessionId, username);
        System.out.println("Started session for user: " + username);
    }

    // Method to validate a session
    public boolean validateSession(String sessionId, String expectedUsername) {
        // Check if sessionId and expectedUsername are not null
        if (sessionId == null || expectedUsername == null) {
            System.out.println("One or more parameters are null, invalid session!");
            return false;
        }

        // Check if session exists
        if (!sessions.containsKey(sessionId)) {
            System.out.println("Invalid session, session does not exist!");
            return false;
        }

        // Check if the username in the session matches the expected username
        if (!sessions.get(sessionId).equals(expectedUsername)) {
            System.out.println("Invalid session, user does not have permission!");
            return false;
        }

        System.out.println("Validated session for user: " + expectedUsername);
        return true;
    }

    // Method to end a session
    public void endSession(String sessionId) {
        // Remove session from the map
        sessions.remove(sessionId);
        System.out.println("Ended session for user: " + sessions.get(sessionId));
    }
}