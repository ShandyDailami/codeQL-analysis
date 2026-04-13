import java.util.*;

public class java_29418_SessionManager_A08 {

    // Creating a static HashMap to store session IDs and User IDs
    private static HashMap<String, String> sessionMap = new HashMap<>();

    // Method to create a new session
    public static String createSession(String userID) {
        // Generate a random session ID
        String sessionID = UUID.randomUUID().toString();

        // Store the session ID and user ID in the session map
        sessionMap.put(sessionID, userID);

        return sessionID;
    }

    // Method to validate a session
    public static boolean validateSession(String sessionID) {
        // Check if the session ID is in the session map
        if (sessionMap.containsKey(sessionID)) {
            // If the session ID is valid, return true
            return true;
        } else {
            // If the session ID is not valid, return false
            return false;
        }
    }

    // Method to get the user ID from a session
    public static String getUserID(String sessionID) {
        // Check if the session ID is in the session map
        if (validateSession(sessionID)) {
            // If the session ID is valid, return the user ID
            return sessionMap.get(sessionID);
        } else {
            // If the session ID is not valid, throw an exception
            throw new SecurityException("Invalid session ID");
        }
    }

    // Method to close a session
    public static void closeSession(String sessionID) {
        // Remove the session ID from the session map
        sessionMap.remove(sessionID);
    }
}