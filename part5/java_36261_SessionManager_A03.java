import java.util.HashMap;
import java.util.Map;

public class java_36261_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_36261_SessionManager_A03() {
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
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Create session
        String sessionId = "session1";
        String userId = "user1";
        sessionManager.createSession(sessionId, userId);

        // Get user from session
        String user = sessionManager.getUserId(sessionId);
        System.out.println("User: " + user); // Outputs: User: user1

        // Delete session
        sessionManager.deleteSession(sessionId);

        // Check if session has been deleted
        user = sessionManager.getUserId(sessionId);
        System.out.println("User: " + user); // Outputs: User: null
    }
}