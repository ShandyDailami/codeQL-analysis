import java.util.HashMap;

public class java_25910_SessionManager_A07 {
    private HashMap<String, String> sessions;

    public java_25910_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    public String getSessionId(String username) {
        if (sessions.containsKey(username)) {
            return sessions.get(username);
        } else {
            String sessionId = createSessionId(username);
            sessions.put(username, sessionId);
            return sessionId;
        }
    }

    private String createSessionId(String username) {
        // This is a simple hashing algorithm that might not be secure for real use-cases
        return String.valueOf(username.hashCode());
    }

    public void invalidateSession(String sessionId) {
        // In a real use-case, you would likely want to implement a more secure method of invalidating sessions
        sessions.remove(sessionId);
    }
}