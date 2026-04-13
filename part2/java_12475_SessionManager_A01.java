import java.util.HashMap;
import java.util.Map;

public class java_12475_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_12475_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        String sessionId = sessionManager.createSession("user1");
        System.out.println("Created session: " + sessionId);
        String userId = sessionManager.getUserId(sessionId);
        System.out.println("User ID in session: " + userId);
        sessionManager.destroySession(sessionId);
        System.out.println("Destroyed session: " + sessionId);
    }
}