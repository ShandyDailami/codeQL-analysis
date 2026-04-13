import java.util.HashMap;
import java.util.Map;

public class java_25823_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_25823_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String username) {
        sessionMap.put(sessionId, username);
    }

    public String getUsername(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null;
        }
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        manager.startSession("session1", "user1");
        manager.startSession("session2", "user2");

        String username = manager.getUsername("session1");
        System.out.println("Username of session1: " + username);

        manager.endSession("session1");

        username = manager.getUsername("session1");
        System.out.println("Username of session1 after session1 has been ended: " + username);
    }
}