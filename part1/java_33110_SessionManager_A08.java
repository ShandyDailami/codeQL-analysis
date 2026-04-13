import java.util.HashMap;
import java.util.Map;

public class java_33110_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_33110_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        // Create a unique session key based on the username
        String sessionKey = username + System.currentTimeMillis();

        // Store the session key in the session map
        sessionMap.put(sessionKey, username);

        return sessionKey;
    }

    public String getUsername(String sessionKey) {
        // Retrieve the username from the session map using the session key
        return sessionMap.get(sessionKey);
    }

    public void deleteSession(String sessionKey) {
        // Remove the session key from the session map
        sessionMap.remove(sessionKey);
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        // Create a session
        String sessionKey = manager.createSession("alice");
        System.out.println("Created session: " + sessionKey);

        // Retrieve the username from the session
        String username = manager.getUsername(sessionKey);
        System.out.println("Retrieved username: " + username);

        // Delete the session
        manager.deleteSession(sessionKey);
        System.out.println("Deleted session: " + sessionKey);
    }
}