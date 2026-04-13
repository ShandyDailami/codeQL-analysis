import java.util.HashMap;
import java.util.Map;

public class java_25118_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_25118_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String username) {
        sessionMap.put(sessionId, username);
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();
        manager.createSession("session1", "user1");
        System.out.println(manager.getUsername("session1")); // prints "user1"
        manager.destroySession("session1");
    }
}