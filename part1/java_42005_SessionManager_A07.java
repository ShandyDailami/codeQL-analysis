import java.util.HashMap;
import java.util.Map;

public class java_42005_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_42005_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId() {
        // This method is a placeholder. It should be replaced with a
        // more complex mechanism for generating session IDs.
        return "sessionId";
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        String userId = "user1";
        String sessionId = sessionManager.createSession(userId);
        System.out.println("Created session with ID: " + sessionId);

        String user = sessionManager.getUserId(sessionId);
        System.out.println("Retrieved user ID: " + user);

        sessionManager.deleteSession(sessionId);
        System.out.println("Deleted session with ID: " + sessionId);
    }
}