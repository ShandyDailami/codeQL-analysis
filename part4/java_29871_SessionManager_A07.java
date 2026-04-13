import java.util.HashMap;

public class java_29871_SessionManager_A07 {
    private HashMap<String, String> sessionMap;

    public java_29871_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    public void startSession(String username) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, username);
        System.out.println("Session started with ID: " + sessionId);
    }

    public void endSession(String sessionId) {
        String username = sessionMap.get(sessionId);
        sessionMap.remove(sessionId);
        System.out.println("Session ended for user: " + username);
    }

    private String generateSessionId() {
        return java.util.UUID.randomUUID().toString();
    }
}