import java.util.HashMap;
import java.util.Map;

public class java_25156_SessionManager_A03 {

    private Map<String, String> sessionMap;

    public java_25156_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();
        sm.startSession("session1", "user1");
        sm.startSession("session2", "user2");
        System.out.println(sm.getUserId("session1")); // Should print user1
        sm.endSession("session1");
        System.out.println(sm.getUserId("session1")); // Should print user1 (session1 is ended)
        System.out.println(sm.getUserId("session2")); // Should print user2
    }
}