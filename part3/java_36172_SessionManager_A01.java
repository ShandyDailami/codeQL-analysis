import java.util.HashMap;
import java.util.Map;

public class java_36172_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_36172_SessionManager_A01() {
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

        // Create a session
        String sessionId = "123";
        String userId = "user1";
        sessionManager.createSession(sessionId, userId);

        // Get user id from session
        String user = sessionManager.getUserIdBySessionId(sessionId);
        System.out.println("User: " + user); // Outputs: User: user1

        // Delete session
        sessionManager.deleteSession(sessionId);

        // Try to get user id from deleted session
        user = sessionManager.getUserIdBySessionId(sessionId);
        System.out.println("User after delete: " + user); // Outputs: User after delete: null
    }
}