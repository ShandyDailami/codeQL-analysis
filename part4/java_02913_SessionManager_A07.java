public class java_02913_SessionManager_A07 {

    // Define a HashMap to store sessions
    private Map<String, String> sessionMap;

    // Constructor
    public java_02913_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String userId) {
        // Generate a session id
        String sessionId = UUID.randomUUID().toString();

        // Store the user id in the session map
        sessionMap.put(sessionId, userId);

        return sessionId;
    }

    // Method to validate a session
    public boolean validateSession(String sessionId) {
        // Check if the session map contains the session id
        return sessionMap.containsKey(sessionId);
    }

    // Method to get the user id from a session
    public String getUserIdFromSession(String sessionId) {
        // If the session is valid, return the user id
        if (validateSession(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            // If the session is not valid, throw an exception
            throw new AuthFailureException("Invalid session");
        }
    }

    // Method to end a session
    public void endSession(String sessionId) {
        // Remove the session from the session map
        sessionMap.remove(sessionId);
    }
}