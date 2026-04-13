import java.util.*;

public class java_41972_SessionManager_A01 {
    private Map<String, String> sessions;

    public java_41972_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = UUID.randomUUID().toString();
        sessions.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessions.getOrDefault(sessionId, null);
    }

    public void deleteSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public boolean checkAccess(String sessionId, String expectedUsername) {
        String username = sessions.getOrDefault(sessionId, null);
        return username != null && username.equals(expectedUsername);
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        String sessionId = manager.createSession("alice");
        System.out.println("Created session with ID: " + sessionId);

        String username = manager.getUsername(sessionId);
        System.out.println("Expected username: alice, Actual username: " + username);

        boolean accessGranted = manager.checkAccess(sessionId, "alice");
        System.out.println("Expected access: true, Actual access: " + accessGranted);

        manager.deleteSession(sessionId);

        username = manager.getUsername(sessionId);
        System.out.println("Expected username: null, Actual username: " + username);

        accessGranted = manager.checkAccess(sessionId, "alice");
        System.out.println("Expected access: false, Actual access: " + accessGranted);
    }
}