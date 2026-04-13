public class java_15676_SessionManager_A08 {
    private static final Logger logger = Logger.getLogger(SecureSessionManager.class);

    // This is a placeholder for the actual session storage.
    private Map<String, String> sessionStorage = new HashMap<>();

    public String createSession(String userId) {
        // Implement session creation logic here.
        // This could include things like checking if the user is valid, etc.

        // For simplicity, we'll just create a random session ID.
        String sessionId = UUID.randomUUID().toString();
        sessionStorage.put(sessionId, userId);

        return sessionId;
    }

    public String getUserId(String sessionId) {
        // Implement session retrieval logic here.
        // This could include things like validating the session ID, etc.

        return sessionStorage.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        // Implement session deletion logic here.
        // This could include things like invalidating the session ID, etc.

        sessionStorage.remove(sessionId);
    }
}