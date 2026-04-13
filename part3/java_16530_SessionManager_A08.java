public class java_16530_SessionManager_A08 {

    // Create a HashMap to store the sessions
    private HashMap<String, String> sessionMap;

    // Constructor to initialize the session map
    public java_16530_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String userID) {
        // Generate a random session key
        String sessionKey = UUID.randomUUID().toString();
        // Store the session key and user ID in the session map
        sessionMap.put(sessionKey, userID);
        // Return the session key
        return sessionKey;
    }

    // Method to validate a session
    public String validateSession(String sessionKey) {
        // Check if the session key exists in the session map
        if (sessionMap.containsKey(sessionKey)) {
            // Get the user ID from the session map
            String userID = sessionMap.get(sessionKey);
            // Return the user ID
            return userID;
        } else {
            // Return null if the session key does not exist
            return null;
        }
    }

    // Method to remove a session
    public void removeSession(String sessionKey) {
        // Remove the session key from the session map
        sessionMap.remove(sessionKey);
    }
}