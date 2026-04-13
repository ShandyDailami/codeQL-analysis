import java.util.HashMap;
import java.util.Map;

public class java_01784_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_01784_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessionMap.getOrDefault(sessionId, null);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId() {
        // This is a simple session id generation. In a real application, you should generate a unique id based on some user information.
        return "sessionId" + System.currentTimeMillis();
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Create a session
        String sessionId = sessionManager.createSession("alice");
        System.out.println("Created session with id: " + sessionId);

        // Get the username
        String username = sessionManager.getUsername(sessionId);
        System.out.println("Username: " + username);

        // Remove the session
        sessionManager.removeSession(sessionId);
    }
}