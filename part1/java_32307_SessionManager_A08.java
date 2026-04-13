public class java_32307_SessionManager_A08 {

    // Private instance of SessionManager
    private static SessionManager sessionManager = null;

    // Private constructor to prevent instantiation of the class from outside
    private java_32307_SessionManager_A08() {}

    // Public static method to return the Singleton instance
    public static SessionManager getInstance() {
        if (sessionManager == null) {
            sessionManager = new SessionManager();
        }
        return sessionManager;
    }

    // Public method to start a session
    public void startSession(String sessionId) {
        // Security-sensitive operation: Check if sessionId is null or empty
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }

        // Security-sensitive operation: Start the session
        System.out.println("Started session with ID: " + sessionId);
    }

    // Public method to end a session
    public void endSession(String sessionId) {
        // Security-sensitive operation: Check if sessionId is null or empty
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }

        // Security-sensitive operation: End the session
        System.out.println("Ended session with ID: " + sessionId);
    }
}