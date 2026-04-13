import java.util.HashMap;
import java.util.Map;

public class java_32852_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_32852_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            System.out.println("Session not found!");
            return null;
        }
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.createSession("session1", "user1");
        System.out.println(sessionManager.getUserId("session1")); // should print user1

        sessionManager.createSession("session2", "user2");
        System.out.println(sessionManager.getUserId("session2")); // should print user2

        sessionManager.removeSession("session1");
        System.out.println(sessionManager.getUserId("session1")); // should print null
    }
}