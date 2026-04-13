import java.util.HashMap;

public class java_15304_SessionManager_A01 {
    private HashMap<String, String> sessions;

    public java_15304_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public void startSession(String username) {
        String sessionId = generateSessionId();
        sessions.put(sessionId, username);
        System.out.println("Started session for user " + username + " with ID " + sessionId);
    }

    public void endSession(String sessionId) {
        String username = sessions.get(sessionId);
        sessions.remove(sessionId);
        System.out.println("Ended session for user " + username + " with ID " + sessionId);
    }

    private String generateSessionId() {
        return "SESSION_" + System.currentTimeMillis();
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.startSession("User1");
        sessionManager.startSession("User2");
        sessionManager.endSession(sessionManager.sessions.get("SESSION_1629494899119"));
    }
}