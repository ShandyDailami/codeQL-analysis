import java.util.HashMap;
import java.util.Map;

public class java_03987_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_03987_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = userId + "_" + System.currentTimeMillis();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Security-sensitive operations related to A08_IntegrityFailure
    public void checkSessionIntegrity(String sessionId) {
        String userId = sessionMap.get(sessionId);
        if (userId == null) {
            throw new SecurityException("Invalid session: " + sessionId);
        }
        // Check user's permissions here
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        String sessionId = sessionManager.createSession("user1");
        System.out.println("Created session: " + sessionId);

        String user = sessionManager.getUserFromSession(sessionId);
        System.out.println("User in session: " + user);

        // Check session integrity
        sessionManager.checkSessionIntegrity(sessionId);

        // Delete session
        sessionManager.deleteSession(sessionId);
    }
}