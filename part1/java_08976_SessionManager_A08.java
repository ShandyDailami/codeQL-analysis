public class java_08976_SessionManager_A08 {
    // Create a static map for storing sessions
    private static Map<String, String> sessionMap = new HashMap<>();

    // Create a method to create a session
    public static String createSession(String userID) {
        // Create a session ID using a UUID
        String sessionID = UUID.randomUUID().toString();

        // Store the session ID in the map
        sessionMap.put(sessionID, userID);

        // Return the session ID
        return sessionID;
    }

    // Create a method to validate a session
    public static String validateSession(String sessionID) throws Exception {
        // If the session ID is not found in the map
        if (!sessionMap.containsKey(sessionID)) {
            // Throw an exception
            throw new Exception("Invalid Session ID");
        }

        // Return the user ID from the map
        return sessionMap.get(sessionID);
    }

    // Create a method to delete a session
    public static void deleteSession(String sessionID) {
        // Remove the session ID from the map
        sessionMap.remove(sessionID);
    }
}