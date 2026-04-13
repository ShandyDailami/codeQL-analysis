import java.util.HashMap;
import java.util.Map;

public class java_26204_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_26204_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void addSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.addSession("session1", "user1");
        sessionManager.addSession("session2", "user2");

        System.out.println(sessionManager.getUserId("session1")); // Should print "user1"
        System.out.println(sessionManager.getUserId("session2")); // Should print "user2"

        sessionManager.removeSession("session1");
        System.out.println(sessionManager.getUserId("session1")); // Should print null
    }
}