public class java_41033_SessionManager_A08 {

    // A simple hash map to simulate a database
    private HashMap<String, String> sessionMap = new HashMap<>();

    // This method creates a new session for a user
    public void createSession(String userId, String sessionId) {
        sessionMap.put(sessionId, userId);
    }

    // This method destroys an existing session
    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // This method gets the userId associated with a session
    public String getSessionUser(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // This method checks if a session is valid
    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    // This method generates a new session ID
    public String generateSessionId() {
        return UUID.randomUUID().toString();
    }
}