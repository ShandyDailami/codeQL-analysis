import java.util.HashMap;

public class java_28266_SessionManager_A01 {
    private HashMap<String, String> sessions;

    public java_28266_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = username + System.currentTimeMillis(); // generate a session ID based on the username and current time
        sessions.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessions.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }
}