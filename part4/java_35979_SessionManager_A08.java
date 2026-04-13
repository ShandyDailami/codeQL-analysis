import java.util.HashMap;
import java.util.Map;

public class java_35979_SessionManager_A08 {

    private Map<String, String> sessionMap;

    public java_35979_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isSessionActive(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        manager.startSession("session1", "user1");
        System.out.println(manager.getUserId("session1")); // should print user1

        manager.startSession("session2", "user2");
        System.out.println(manager.getUserId("session2")); // should print user2

        manager.endSession("session1");
        System.out.println(manager.isSessionActive("session1")); // should print false

        System.out.println(manager.getUserId("session2")); // should print user2
    }
}