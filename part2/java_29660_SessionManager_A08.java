import java.util.HashMap;

public class java_29660_SessionManager_A08 {
    // Create a static hashmap for sessions
    private static HashMap<String, String> sessionMap = new HashMap<>();

    // Method to create a session
    public static String createSession(String userId) {
        // Generate a unique session key
        String sessionKey = userId + System.currentTimeMillis();

        // Store the session key and user id in the session map
        sessionMap.put(sessionKey, userId);

        // Return the session key
        return sessionKey;
    }

    // Method to get the user id from a session key
    public static String getUserIdFromSession(String sessionKey) {
        // Return the user id from the session map
        return sessionMap.get(sessionKey);
    }

    // Method to validate a session
    public static boolean validateSession(String sessionKey) {
        // Check if the session key exists in the session map
        if (sessionMap.containsKey(sessionKey)) {
            // Return true, indicating a valid session
            return true;
        } else {
            // Return false, indicating an invalid session
            return false;
        }
    }

    // Method to destroy a session
    public static void destroySession(String sessionKey) {
        // Remove the session key from the session map
        sessionMap.remove(sessionKey);
    }
}