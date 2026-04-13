import java.util.HashMap;
import java.util.Map;

public class java_38683_SessionManager_A08 {

    private Map<String, String> sessionMap;

    public java_38683_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String username) {
        sessionMap.put(sessionId, username);
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean sessionExists(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Create session
        sessionManager.createSession("session1", "user1");

        // Get username
        System.out.println("Username: " + sessionManager.getUsername("session1"));

        // Delete session
        sessionManager.deleteSession("session1");

        // Check if session exists
        System.out.println("Does session1 exist? " + sessionManager.sessionExists("session1"));
    }
}