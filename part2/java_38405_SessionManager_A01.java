import java.util.HashMap;
import java.util.Map;

public class java_38405_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_38405_SessionManager_A01() {
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
}

public class Main {
    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        manager.createSession("session1", "user1");
        manager.createSession("session2", "user2");

        System.out.println("User1: " + manager.getUserId("session1"));
        System.out.println("User2: " + manager.getUserId("session2"));

        manager.deleteSession("session1");

        System.out.println("User1 after session1 deleted: " + manager.getUserId("session1"));
    }
}