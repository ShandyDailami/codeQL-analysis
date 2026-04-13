import java.util.HashMap;
import java.util.Map;

public class java_26786_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_26786_SessionManager_A01() {
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
        SessionManager manager = new SessionManager();
        manager.createSession("session1", "user1");
        System.out.println(manager.getUserId("session1")); // prints "user1"
        manager.deleteSession("session1");
        System.out.println(manager.getUserId("session1")); // prints null
    }
}