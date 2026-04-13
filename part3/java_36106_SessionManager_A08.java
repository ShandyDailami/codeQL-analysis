import java.util.HashMap;

public class java_36106_SessionManager_A08 {
    private HashMap<String, String> sessionMap;

    // Constructor
    public java_36106_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
    }

    // Method to start a new session
    public String startSession(String username) {
        String sessionId = generateSessionId(username);
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    // Method to end a session
    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            throw new SecurityFailureException("Tried to end a session that does not exist or has already been ended");
        }
    }

    // Method to get the username for a given session
    public String getUsername(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new SecurityFailureException("Tried to get a username for a session that does not exist or has already been ended");
        }
    }

    // Helper method to generate session id
    private String generateSessionId(String username) {
        return username + System.currentTimeMillis();
    }
}