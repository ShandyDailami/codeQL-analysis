public class java_14245_SessionManager_A01 {
    private static final String SPECIFIC_SESSION_KEY = "specific_session_key";
    private static final String SECRET_KEY = "secret_key";
    private static Map<String, String> sessionMap;

    // Create Session Manager
    public java_14245_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Create Session
    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Get User from Session
    public String getUserFromSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new IllegalArgumentException("Invalid session id");
        }
    }

    // Validate Session
    public boolean isValidSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId).equals(userId);
        } else {
            throw new IllegalArgumentException("Invalid session id");
        }
    }

    // Delete Session
    public void deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            throw new IllegalArgumentException("Invalid session id");
        }
    }

    // Validate Session with Secret Key
    public boolean isValidSessionWithSecretKey(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId).equals(SECRET_KEY);
        } else {
            throw new IllegalArgumentException("Invalid session id");
        }
    }

    // Break Access Control
    public void breakAccessControl() {
        // Use sessionId to access other user's session
        getUserFromSession(SPECIFIC_SESSION_KEY);
        // Validate with secret key
        isValidSessionWithSecretKey(SPECIFIC_SESSION_KEY);
    }
}