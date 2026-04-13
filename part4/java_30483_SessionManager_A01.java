import java.util.HashMap;

public class java_30483_SessionManager_A01 {
    private HashMap<String, String> sessions;

    public java_30483_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public void startSession(String userId) {
        String sessionId = generateSessionId();
        sessions.put(sessionId, userId);
        System.out.println("Session started with ID: " + sessionId);
    }

    public String getUserId(String sessionId) {
        return sessions.get(sessionId);
    }

    public void endSession(String sessionId) {
        String userId = sessions.get(sessionId);
        if (userId != null) {
            sessions.remove(sessionId);
            System.out.println("Session ended for user: " + userId);
        } else {
            System.out.println("No session found for ID: " + sessionId);
        }
    }

    private String generateSessionId() {
        // This is a simple implementation which generates a random ID
        return String.valueOf(System.currentTimeMillis());
    }
}