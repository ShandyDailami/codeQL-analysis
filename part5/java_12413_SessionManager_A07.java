import java.util.HashMap;

public class java_12413_SessionManager_A07 {
    // Create a static HashMap to store the sessions
    private static HashMap<String, String> sessionMap = new HashMap<>();

    // Method to start a session
    public static void startSession(String userId) {
        // Generate a session id and store it in the session map
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, userId);
    }

    // Method to end a session
    public static void endSession(String sessionId) {
        // Remove the session id from the session map
        sessionMap.remove(sessionId);
    }

    // Method to validate a session
    public static boolean isValidSession(String sessionId) {
        // Check if the session id is in the session map
        return sessionMap.containsKey(sessionId);
    }

    // Method to get the user id from a session
    public static String getUserId(String sessionId) {
        // If the session id is valid, return the user id
        if (isValidSession(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            // If the session id is not valid, throw an exception
            throw new IllegalArgumentException("Invalid Session");
        }
    }

    // Method to generate a session id
    private static String generateSessionId() {
        // Generate a random session id and return it
        return String.valueOf(System.currentTimeMillis());
    }
}