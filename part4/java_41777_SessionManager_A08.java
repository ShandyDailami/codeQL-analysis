public class java_41777_SessionManager_A08 {

    // Define a static map to hold sessions
    private static Map<String, String> sessionMap;

    // Initialize the map
    static {
        sessionMap = new HashMap<String, String>();
    }

    // Method to create a session
    public String createSession(String sessionId) {
        // Validate the session ID
        if(sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }
        // Add the session to the map
        sessionMap.put(sessionId, sessionId);
        return "Session Created";
    }

    // Method to validate a session
    public String validateSession(String sessionId) {
        // Validate the session ID
        if(sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }
        // Check if the session ID exists in the map
        if(sessionMap.containsKey(sessionId)) {
            return "Session Validated";
        } else {
            return "Session Invalid";
        }
    }

    // Method to close a session
    public String closeSession(String sessionId) {
        // Validate the session ID
        if(sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }
        // Remove the session from the map
        sessionMap.remove(sessionId);
        return "Session Closed";
    }
}