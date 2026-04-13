public class java_13896_SessionManager_A01 {
    private HashMap<String, String> sessions;

    public java_13896_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    // Method to start a session
    public String startSession(String username) {
        String sessionId = UUID.randomUUID().toString();
        sessions.put(sessionId, username);
        return sessionId;
    }

    // Method to end a session
    public void endSession(String sessionId) {
        sessions.remove(sessionId);
    }

    // Method to get the username of a session
    public String getUsername(String sessionId) {
        return sessions.get(sessionId);
    }

    // Method to check if a session is active
    public boolean isSessionActive(String sessionId) {
        return sessions.containsKey(sessionId);
    }

    // Method to check if a username is in use
    public boolean isUsernameInUse(String username) {
        for (String sessionId : sessions.values()) {
            if (sessionId.equals(username)) {
                return true;
            }
        }
        return false;
    }
}