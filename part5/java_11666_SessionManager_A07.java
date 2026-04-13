import java.util.HashMap;
import java.util.Map;

public class java_11666_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_11666_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String username) {
        sessionMap.put(sessionId, username);
    }

    public String getUsername(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null; // Session not found
        }
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        manager.createSession("session1", "alice");
        String username = manager.getUsername("session1");
        System.out.println("Username: " + username); // Output: Username: alice

        manager.createSession("session2", "bob");
        username = manager.getUsername("session2");
        System.out.println("Username: " + username); // Output: Username: bob

        manager.deleteSession("session1");
        username = manager.getUsername("session1");
        System.out.println("Username: " + username); // Output: Username: null
    }
}