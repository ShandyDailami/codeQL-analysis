import java.util.HashMap;
import java.util.Map;

public class java_17805_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_17805_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SecureSessionManager sessionManager = new SecureSessionManager();

        String userId = "user1";
        String sessionId = sessionManager.createSession(userId);

        // Valid session
        if (sessionManager.isValidSession(sessionId)) {
            System.out.println("Session is valid. User ID: " + sessionManager.getUserId(sessionId));
        } else {
            System.out.println("Invalid session!");
        }

        // Unauthorized operation
        try {
            String unauthorizedUserId = sessionManager.getUserId("unauthorizedSession");
        } catch (IllegalStateException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // Delete session
        sessionManager.deleteSession(sessionId);
    }
}