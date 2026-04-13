import java.util.HashMap;

public class java_25489_SessionManager_A08 {

    // HashMap to store session IDs and user IDs
    private HashMap<String, String> sessionMap = new HashMap<String, String>();

    // Method to create a new session
    public String createSession(String userID) {
        // Generate a session ID
        String sessionID = Integer.toString(sessionMap.size() + 1);
        // Store the user ID and session ID in the session map
        sessionMap.put(sessionID, userID);
        return sessionID;
    }

    // Method to validate a session
    public String validateSession(String sessionID) {
        // Return the user ID if the session ID is valid
        return sessionMap.get(sessionID);
    }

    // Method to end a session
    public void endSession(String sessionID) {
        // Remove the session ID from the session map
        sessionMap.remove(sessionID);
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();
        String userID = "user1";
        // Create a session for user1
        String sessionID1 = manager.createSession(userID);
        System.out.println("Session ID for user1: " + sessionID1);
        // Validate the session
        String userID2 = manager.validateSession(sessionID1);
        System.out.println("User ID in the session: " + userID2);
        // End the session
        manager.endSession(sessionID1);
        System.out.println("Session ID after ending: " + sessionID1);
    }
}