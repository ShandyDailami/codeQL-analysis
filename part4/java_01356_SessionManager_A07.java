import java.util.HashMap;
import java.util.Map;

public class java_01356_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_01356_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void addSession(String sessionId, String username) {
        sessionMap.put(sessionId, username);
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.addSession("session1", "user1");
        sessionManager.addSession("session2", "user2");

        System.out.println(sessionManager.getUsername("session1")); // user1
        System.out.println(sessionManager.getUsername("session2")); // user2

        sessionManager.removeSession("session1");

        System.out.println(sessionManager.getUsername("session1")); // null
    }
}