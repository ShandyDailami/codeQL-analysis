public class java_08389_SessionManager_A07 {
    // Define a HashMap to store session data
    private HashMap<String, String> sessionData;

    // Constructor
    public java_08389_SessionManager_A07() {
        this.sessionData = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String userID) {
        // Generate a session ID
        String sessionID = UUID.randomUUID().toString();

        // Store the session data in the HashMap
        sessionData.put(sessionID, userID);

        // Return the session ID
        return sessionID;
    }

    // Method to validate a session
    public String validateSession(String sessionID) {
        // Check if the session ID exists in the HashMap
        if (sessionData.containsKey(sessionID)) {
            // Return the user ID associated with the session ID
            return sessionData.get(sessionID);
        } else {
            // Return null if the session ID does not exist
            return null;
        }
    }

    // Method to remove a session
    public void removeSession(String sessionID) {
        // Remove the session ID from the HashMap
        sessionData.remove(sessionID);
    }
}