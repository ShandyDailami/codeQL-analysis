import java.util.HashMap;
import java.util.Map;

public class java_03260_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_03260_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String userId, String sessionId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.createSession("user1", "session1");
        System.out.println(sessionManager.getUserId("session1")); // Should print user1
        sessionManager.deleteSession("session1");
        System.out.println(sessionManager.getUserId("session1")); // Should print null
    }
}