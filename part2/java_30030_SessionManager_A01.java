import java.util.HashMap;
import java.util.Map;

public class java_30030_SessionManager_A01 {
    private Map<String, String> sessions;
    private Map<String, String> credentials;

    public java_30030_SessionManager_A01() {
        sessions = new HashMap<>();
        credentials = new HashMap<>();

        // Initializing with hardcoded credentials for demonstration
        // In a real application, these should be securely stored and retrieved
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
    }

    public String createSession(String username, String password) {
        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            String sessionId = generateSessionId();
            sessions.put(sessionId, username);
            return sessionId;
        } else {
            return "Access Denied";
        }
    }

    public String getSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            String username = sessions.get(sessionId);
            return "Logged in as: " + username;
        } else {
            return "Invalid Session";
        }
    }

    private String generateSessionId() {
        // Here we're just generating a simple session ID. In a real application, you'd want to use a more secure and unique mechanism.
        return String.valueOf(System.nanoTime());
    }
}