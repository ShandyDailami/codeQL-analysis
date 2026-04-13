import java.util.HashMap;
import java.util.Map;

public class java_32021_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_32021_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId() {
        // This is a simple example of a session id generation. You should use a more secure and random method.
        return String.valueOf(System.currentTimeMillis());
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        String sessionId = sessionManager.createSession("admin");
        System.out.println("Created session with ID: " + sessionId);

        String username = sessionManager.getUsername(sessionId);
        System.out.println("Username: " + username);

        sessionManager.removeSession(sessionId);
        System.out.println("Session removed");
    }
}