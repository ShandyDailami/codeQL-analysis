import java.util.HashMap;
import java.util.Map;

public class java_27562_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_27562_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isSessionValid(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void updateUserId(String oldSessionId, String newSessionId, String userId) {
        if (sessionMap.containsKey(oldSessionId)) {
            sessionMap.remove(oldSessionId);
            sessionMap.put(newSessionId, userId);
        } else {
            System.out.println("Session not found");
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Create session
        sessionManager.createSession("session1", "user1");

        // Get userId from session
        String userId = sessionManager.getUserId("session1");
        System.out.println("User ID: " + userId);

        // Update userId in session
        sessionManager.updateUserId("session1", "session2", "user2");

        // Check if session is valid
        boolean isValid = sessionManager.isSessionValid("session2");
        System.out.println("Is Valid: " + isValid);

        // Delete session
        sessionManager.deleteSession("session2");
    }
}