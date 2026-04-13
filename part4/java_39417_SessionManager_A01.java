import java.util.HashMap;
import java.util.Map;

public class java_39417_SessionManager_A01 {
    private Map<String, String> sessions;
    private Map<String, String> credentials;

    public java_39417_SessionManager_A01() {
        sessions = new HashMap<>();
        credentials = new HashMap<>();
    }

    public String createSession(String username, String password) {
        // Create a new session id using a secure method (e.g., hashing or encryption)
        String sessionId = /* secure method */;

        // Store the session id and the username in the session map
        sessions.put(sessionId, username);

        // Store the username and password in the credentials map for authentication later
        credentials.put(username, password);

        return sessionId;
    }

    public String getUsername(String sessionId) {
        // Get the username from the session map
        return sessions.get(sessionId);
    }

    public boolean authenticate(String username, String password) {
        // Authenticate the username and password using stored credentials
        return credentials.get(username).equals(password);
    }
}