import java.util.HashMap;
import java.util.Map;

public class java_07686_SessionManager_A03 {
    private Map<String, String> credentials;
    private Map<String, String> session;

    public java_07686_SessionManager_A03() {
        credentials = new HashMap<>();
        session = new HashMap<>();

        // Add some default credentials
        credentials.put("admin", "password");
    }

    public String getUsername(String sessionId) {
        return session.get(sessionId);
    }

    public boolean authenticate(String username, String password) {
        String expectedPassword = credentials.get(username);
        return password.equals(expectedPassword);
    }

    public String startSession(String username) {
        // Generate a session ID
        String sessionId = String.valueOf(System.currentTimeMillis());

        // Store the session ID and username
        session.put(sessionId, username);

        return sessionId;
    }

    public void endSession(String sessionId) {
        // Remove the session ID and username
        session.remove(sessionId);
    }
}