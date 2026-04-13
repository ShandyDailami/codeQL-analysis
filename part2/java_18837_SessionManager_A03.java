import java.util.HashMap;
import java.util.Map;

public class java_18837_SessionManager_A03 {

    private Map<String, String> sessionMap;

    public java_18837_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.createSession("session1", "user1");
        System.out.println(sessionManager.getUserId("session1")); // Should print user1
        sessionManager.endSession("session1");
        System.out.println(sessionManager.getUserId("session1")); // Should print null
    }
}