import java.util.HashMap;
import java.util.Map;

public class java_09260_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_09260_SessionManager_A07() {
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

    // Helper method to generate a unique session id
    private String generateSessionId() {
        // This is a simple example, in a real-world application you would likely use a UUID here
        return String.valueOf(System.nanoTime());
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        String sessionId = manager.createSession("alice");
        System.out.println("Created session: " + sessionId);

        String username = manager.getUsername(sessionId);
        System.out.println("Username: " + username);

        manager.removeSession(sessionId);
        System.out.println("Removed session: " + sessionId);
    }
}