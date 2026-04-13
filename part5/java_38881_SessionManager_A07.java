import java.util.HashMap;
import java.util.Map;

public class java_38881_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_38881_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserIdFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.createSession("session1", "user1");
        String userId = sessionManager.getUserIdFromSession("session1");
        System.out.println("User ID: " + userId); // Should print: User ID: user1

        sessionManager.deleteSession("session1");
        userId = sessionManager.getUserIdFromSession("session1");
        System.out.println("User ID: " + userId); // Should print: User ID: null
    }
}