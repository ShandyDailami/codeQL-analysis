import java.util.HashMap;
import java.util.Map;

public class java_28737_SessionManager_A01 {
    private Map<String, String> sessions;

    public java_28737_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public String createSession(String user) {
        // Generate a session key for the user
        String sessionKey = user + System.currentTimeMillis();
        sessions.put(sessionKey, user);
        return sessionKey;
    }

    public String getUser(String sessionKey) {
        // Retrieve the user from the session key
        return sessions.get(sessionKey);
    }

    public void deleteSession(String sessionKey) {
        // Delete the session by invalidating the session key
        sessions.remove(sessionKey);
    }
}