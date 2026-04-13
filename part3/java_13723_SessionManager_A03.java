import java.util.HashMap;
import java.util.Map;

public class java_13723_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_13723_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserIdBySessionId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Create session
        String sessionId = "session1";
        String userId = "user1";
        sessionManager.createSession(sessionId, userId);

        // Get userId by sessionId
        String userIdBySessionId = sessionManager.getUserIdBySessionId(sessionId);
        System.out.println("UserId by sessionId: " + userIdBySessionId); // should print user1

        // Delete session
        sessionManager.deleteSession(sessionId);

        // Try to get userId by sessionId after deletion, should print null
        userIdBySessionId = sessionManager.getUserIdBySessionId(sessionId);
        System.out.println("UserId by sessionId after deletion: " + userIdBySessionId); // should print null
    }
}