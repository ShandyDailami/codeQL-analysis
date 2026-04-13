import java.util.HashMap;
import java.util.Map;

public class java_13709_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_13709_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String userId, String sessionId) {
        sessionMap.put(userId, sessionId);
    }

    public String getSession(String userId) {
        return sessionMap.get(userId);
    }

    public void deleteSession(String userId) {
        sessionMap.remove(userId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.createSession("user1", "session1");
        sessionManager.createSession("user2", "session2");

        System.out.println("Session 1: " + sessionManager.getSession("user1"));
        System.out.println("Session 2: " + sessionManager.getSession("user2"));

        sessionManager.deleteSession("user1");
        System.out.println("After deleting session for user1, Session 1: " + sessionManager.getSession("user1"));
    }
}