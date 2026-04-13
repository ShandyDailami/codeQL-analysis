import java.util.HashMap;
import java.util.Map;

public class java_04238_SessionManager_A07 {

    // This map will store user sessions.
    private Map<String, String> sessionMap;

    // This map will store user credentials.
    private Map<String, String> credMap;

    public java_04238_SessionManager_A07() {
        sessionMap = new HashMap<>();
        credMap = new HashMap<>();
    }

    // Add a new session.
    public void addSession(String username, String password) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, username);
        credMap.put(sessionId, password);
    }

    // Validate a session.
    public boolean validateSession(String sessionId, String password) {
        if (sessionMap.containsKey(sessionId)) {
            if (sessionMap.get(sessionId).equals(credMap.get(sessionId))) {
                return true;
            }
        }
        return false;
    }

    // Generate a session ID.
    private String generateSessionId() {
        // This is a simple example, in a real-world scenario, you should use a UUID.
        return String.valueOf(System.currentTimeMillis());
    }
}