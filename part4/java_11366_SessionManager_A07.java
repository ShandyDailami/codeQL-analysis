import java.util.HashMap;

public class java_11366_SessionManager_A07 {
    private HashMap<String, String> sessionMap;

    public java_11366_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserIdBySessionId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();

        sm.createSession("session1", "user1");
        sm.createSession("session2", "user2");

        System.out.println(sm.getUserIdBySessionId("session1")); // should print user1
        System.out.println(sm.getUserIdBySessionId("session2")); // should print user2

        sm.deleteSession("session1");
        System.out.println(sm.getUserIdBySessionId("session1")); // should print null
    }
}