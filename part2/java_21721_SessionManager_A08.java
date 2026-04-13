import java.util.HashMap;
import java.util.Map;

public class java_21721_SessionManager_A08 {
    private static Map<String, String> sessionMap;

    public java_21721_SessionManager_A08() {
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
        SessionManager sessionManager = new SessionManager();

        sessionManager.createSession("session1", "user1");

        System.out.println("User ID from session: " + sessionManager.getUserId("session1"));

        sessionManager.deleteSession("session1");

        System.out.println("User ID from session after delete: " + sessionManager.getUserId("session1"));
    }
}