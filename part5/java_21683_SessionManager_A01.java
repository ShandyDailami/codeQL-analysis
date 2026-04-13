import java.util.HashMap;
import java.util.Map;

public class java_21683_SessionManager_A01 {

    private Map<String, String> sessionMap;

    public java_21683_SessionManager_A01() {
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

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Create a session
        String sessionId = "session1";
        String username = "user1";
        sessionManager.createSession(sessionId, username);

        // Get the username
        String retrievedUsername = sessionManager.getUsername(sessionId);
        System.out.println("Retrieved username: " + retrievedUsername);

        // Delete the session
        sessionManager.deleteSession(sessionId);
    }
}