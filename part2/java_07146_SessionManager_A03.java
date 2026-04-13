import java.util.Map;
import java.util.HashMap;

public class java_07146_SessionManager_A03 {
    private Map<String, String> sessions;

    public java_07146_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    public String createSession(String user) {
        String sessionId = generateSessionId();
        sessions.put(sessionId, user);
        return sessionId;
    }

    public String getUser(String sessionId) {
        return sessions.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }

    private String generateSessionId() {
        // This is a simple implementation of generating a random session id.
        // In a real-world scenario, you should use a more secure method.
        return String.valueOf(System.currentTimeMillis() * (new Random().nextInt()));
    }
}

// Example usage:
public class Main {
    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        String sessionId = manager.createSession("John Doe");
        System.out.println("Created session with id: " + sessionId);

        String user = manager.getUser(sessionId);
        System.out.println("User from session: " + user);

        manager.removeSession(sessionId);
        System.out.println("Removed session: " + sessionId);
    }
}