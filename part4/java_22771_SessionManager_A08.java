import java.util.HashMap;
import java.util.Map;

public class java_22771_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_22771_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
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

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void checkSessionIntegrity(String sessionId) {
        if (!isValidSession(sessionId)) {
            throw new SecurityException("Invalid session: " + sessionId);
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        String sessionId = "session1";
        String userId = "user1";

        sessionManager.createSession(sessionId, userId);

        // Testing session integrity
        sessionManager.checkSessionIntegrity(sessionId);

        // Retrieving user from session
        String retrievedUserId = sessionManager.getUserId(sessionId);

        System.out.println("Retrieved user from session: " + retrievedUserId);

        // Deleting session
        sessionManager.deleteSession(sessionId);

        // Testing session integrity after deletion
        try {
            sessionManager.checkSessionIntegrity(sessionId);
        } catch (SecurityException e) {
            System.out.println(e.getMessage());
        }
    }
}