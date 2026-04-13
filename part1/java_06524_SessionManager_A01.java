import java.util.HashMap;
import java.util.Map;

public class java_06524_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_06524_SessionManager_A01() {
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
        // This method is left intentionally blank.
        // The actual implementation would involve generating a unique, secure id.
        return null;
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        String sessionId1 = sessionManager.createSession("alice");
        System.out.println("Created session: " + sessionId1);

        String username = sessionManager.getUsername(sessionId1);
        System.out.println("Username in session: " + username);

        String sessionId2 = sessionManager.createSession("bob");
        System.out.println("Created session: " + sessionId2);

        username = sessionManager.getUsername(sessionId2);
        System.out.println("Username in session: " + username);

        sessionManager.removeSession(sessionId2);
        System.out.println("Removed session: " + sessionId2);
    }
}