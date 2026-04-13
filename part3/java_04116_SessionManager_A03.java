import java.util.HashMap;
import java.util.Map;

public class java_04116_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_04116_SessionManager_A03() {
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
        SessionManager sessionManager = new SessionManager();

        sessionManager.createSession("session1", "user1");
        String userId = sessionManager.getUserIdBySessionId("session1");
        System.out.println("User ID: " + userId); // should print: User ID: user1

        sessionManager.createSession("session2", "user2");
        userId = sessionManager.getUserIdBySessionId("session2");
        System.out.println("User ID: " + userId); // should print: User ID: user2

        sessionManager.deleteSession("session1");
        userId = sessionManager.getUserIdBySessionId("session1");
        System.out.println("User ID: " + userId); // should print: User ID: null, as session1 has been deleted
    }
}