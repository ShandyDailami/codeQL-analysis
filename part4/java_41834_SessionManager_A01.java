import java.util.HashMap;

public class java_41834_SessionManager_A01 {
    private HashMap<String, String> sessions;

    public java_41834_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public void startSession(String username) {
        String sessionId = generateSessionId();
        sessions.put(sessionId, username);
        System.out.println("Started session for user " + username + " with ID " + sessionId);
    }

    public String getUsername(String sessionId) {
        return sessions.get(sessionId);
    }

    public void endSession(String sessionId) {
        String username = sessions.get(sessionId);
        sessions.remove(sessionId);
        System.out.println("Ended session for user " + username);
    }

    private String generateSessionId() {
        // This is a simple example of a session ID generator. In a real-world application,
        // it would use a more complex algorithm to ensure uniqueness and safety.
        return String.valueOf(System.currentTimeMillis());
    }
}