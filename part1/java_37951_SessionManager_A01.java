import java.util.HashMap;

public class java_37951_SessionManager_A01 {
    private HashMap<String, String> sessions;

    public java_37951_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public void startSession(String username) {
        String sessionId = generateSessionId();
        sessions.put(sessionId, username);
        System.out.println("Session started for user " + username + " with ID " + sessionId);
    }

    public String getUserFromSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void endSession(String sessionId) {
        String username = sessions.get(sessionId);
        sessions.remove(sessionId);
        System.out.println("Session ended for user " + username);
    }

    private String generateSessionId() {
        // This is a placeholder, actual implementation may vary.
        // Here we use a simple string for simplicity.
        return "SESSION_" + System.currentTimeMillis();
    }
}