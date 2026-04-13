import java.util.HashMap;

public class java_32194_SessionManager_A01 {
    private HashMap<String, String> sessionMap;

    public java_32194_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userID) {
        // Generate a unique session ID
        String sessionID = generateSessionID(userID);

        // Store the session ID in the map
        sessionMap.put(sessionID, userID);

        // Print a message to indicate the session has started
        System.out.println("Session started with ID: " + sessionID);
    }

    public void endSession(String sessionID) {
        // Find the user ID associated with the session ID
        String userID = sessionMap.get(sessionID);

        // If a user ID is found, remove the session ID from the map
        if (userID != null) {
            sessionMap.remove(sessionID);

            // Print a message to indicate the session has ended
            System.out.println("Session ended with ID: " + sessionID);
        } else {
            // If no user ID is found, print a message to indicate the session was not found
            System.out.println("Session not found with ID: " + sessionID);
        }
    }

    private String generateSessionID(String userID) {
        // This is a simple implementation of a session ID generator. In a real-world application,
        // you would likely want to use a more secure method to generate session IDs.
        return userID;
    }
}