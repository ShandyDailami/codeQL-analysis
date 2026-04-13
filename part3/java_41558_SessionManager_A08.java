import java.util.HashMap;
import java.util.Map;

public class java_41558_SessionManager_A08 {
    private Map<String, String> sessionMap;
    private Map<String, String> authenticationMap;

    public java_41558_SessionManager_A08() {
        sessionMap = new HashMap<>();
        authenticationMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String authenticate(String sessionId, String password) {
        String username = sessionMap.get(sessionId);
        if (username != null && authenticatePassword(username, password)) {
            return username;
        } else {
            return null;
        }
    }

    private String generateSessionId() {
        return Long.toString(System.nanoTime());
    }

    private boolean authenticatePassword(String username, String password) {
        // Here, you would typically use a secure way to authenticate passwords.
        // For simplicity, we'll just check if the password matches the username.
        return password.equals(username);
    }

    public void invalidateSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        String sessionId = manager.createSession("user1");
        System.out.println("Created session with ID: " + sessionId);

        String username = manager.authenticate(sessionId, "user1");
        if (username != null) {
            System.out.println("Authenticated as user: " + username);
        } else {
            System.out.println("Authentication failed");
        }

        manager.invalidateSession(sessionId);
        System.out.println("Invalidated session with ID: " + sessionId);
    }
}