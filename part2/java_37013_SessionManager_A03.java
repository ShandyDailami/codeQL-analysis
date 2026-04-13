import java.util.HashMap;
import java.util.Map;

public class java_37013_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_37013_SessionManager_A03() {
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

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        String userId = "user1";
        String sessionId = sessionManager.createSession(userId);
        System.out.println("Session ID: " + sessionId);
        System.out.println("User ID: " + sessionManager.getUserId(sessionId));
        sessionManager.removeSession(sessionId);
    }
}