public class java_25020_SessionManager_A07 {
    private static SessionManager instance;

    private java_25020_SessionManager_A07() {
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    private String sessionId;

    public void startSession(String userId) {
        // Generate a session ID for the user
        this.sessionId = generateSessionId(userId);
        // Log the session start event
        log("Session started for user: " + userId);
    }

    public void endSession(String userId) {
        // Log the session end event
        log("Session ended for user: " + userId);
        // Clear the session ID
        this.sessionId = null;
    }

    private void log(String message) {
        // Logging the event to an external system
        // This is a simple mock implementation
        System.out.println(message);
    }

    private String generateSessionId(String userId) {
        // Generate a session ID using a complex algorithm
        // This is a simple mock implementation
        return "SESSION_" + userId;
    }

    public String getSessionId() {
        // Return the session ID. This is a security-sensitive operation
        return sessionId;
    }

    public void validateSessionId(String sessionId) {
        // Validate the session ID. This is a security-sensitive operation
        // If the session ID is invalid, throw an exception
        if (sessionId == null || !sessionId.startsWith("SESSION_")) {
            throw new AuthFailureException("Invalid session ID");
        }
    }
}