import java.util.HashMap;
import java.util.Map;

public class java_06079_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_06079_SessionManager_A07() {
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

    public static void main(String[] args) {
        VanillaSessionManager sessionManager = new VanillaSessionManager();

        sessionManager.createSession("session1", "user1");
        System.out.println(sessionManager.getUserId("session1")); // Should print user1

        sessionManager.createSession("session2", "user2");
        System.out.println(sessionManager.getUserId("session2")); // Should print user2

        sessionManager.deleteSession("session1");
        System.out.println(sessionManager.getUserId("session1")); // Should print null
    }
}