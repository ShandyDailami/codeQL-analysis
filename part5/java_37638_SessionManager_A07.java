import java.util.HashMap;
import java.util.Map;

public class java_37638_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_37638_SessionManager_A07() {
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

    // helper method to generate a session ID
    private String generateSessionId() {
        // TODO: implement a secure mechanism for generating session IDs
        // for simplicity, we'll just use a random string
        return "sessionId" + System.nanoTime();
    }

    // For testing purposes
    public static void main(String[] args) {
        SessionManager sm = new SessionManager();
        String sessionId = sm.createSession("testUser");
        System.out.println("Session ID: " + sessionId);
        String username = sm.getUsername(sessionId);
        System.out.println("Username: " + username);
        sm.removeSession(sessionId);
    }
}