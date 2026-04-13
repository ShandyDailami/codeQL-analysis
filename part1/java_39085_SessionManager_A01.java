import java.util.HashMap;
import java.util.Map;

public class java_39085_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_39085_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();
        sm.createSession("session1", "user1");
        sm.createSession("session2", "user2");
        System.out.println("User1 id: " + sm.getUserId("session1"));
        System.out.println("User2 id: " + sm.getUserId("session2"));
        sm.removeSession("session1");
        System.out.println("User1 id after removing session1: " + sm.getUserId("session1"));
    }
}