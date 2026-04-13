import java.util.HashMap;

public class java_07642_SessionManager_A01 {
    private HashMap<String, String> sessions;

    public java_07642_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public void startSession(String username) {
        String sessionId = generateSessionId();
        sessions.put(sessionId, username);
        System.out.println("Session started for user " + username + ". ID: " + sessionId);
    }

    public void endSession(String sessionId) {
        String username = sessions.get(sessionId);
        if (username != null) {
            sessions.remove(sessionId);
            System.out.println("Session ended for user " + username + ". ID: " + sessionId);
        } else {
            System.out.println("Session not found for ID: " + sessionId);
        }
    }

    public String getUsernameForSessionId(String sessionId) {
        return sessions.get(sessionId);
    }

    private String generateSessionId() {
        // Implementation for generating a unique session ID
        // This could be as simple as a UUID, or it could involve more complex logic
        return "sessionId";
    }
}