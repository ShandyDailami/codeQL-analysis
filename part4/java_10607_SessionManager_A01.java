import java.util.HashMap;
import java.util.Map;

public class java_10607_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_10607_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        // Creating a secure session with the username.
        String sessionId = String.valueOf(System.currentTimeMillis());
        sessionMap.put(sessionId, username);

        return sessionId;
    }

    public String getUsername(String sessionId) {
        // Retrieving the username from the session.
        return sessionMap.getOrDefault(sessionId, null);
    }

    public void destroySession(String sessionId) {
        // Destroying the session and removing it from the map.
        sessionMap.remove(sessionId);
    }

    public void validateSession(String sessionId) {
        // Validating the session.
        if (sessionMap.get(sessionId) == null) {
            throw new IllegalArgumentException("Invalid Session: " + sessionId);
        }
    }
}