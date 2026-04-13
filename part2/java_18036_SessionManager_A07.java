import java.util.HashMap;

public class java_18036_SessionManager_A07 {
    private HashMap<String, String> sessions;

    public java_18036_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = username + System.currentTimeMillis();
        sessions.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessions.getOrDefault(sessionId, null);
    }

    public void deleteSession(String sessionId) {
        sessions.remove(sessionId);
    }
}