import java.util.HashMap;
import java.util.Map;

public class java_41417_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_41417_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.createSession("session1", "user1");

        String userId = sessionManager.getUserId("session1");
        System.out.println("User ID: " + userId);

        sessionManager.destroySession("session1");
    }
}