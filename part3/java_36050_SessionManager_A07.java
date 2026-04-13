import java.util.HashMap;
import java.util.Map;

public class java_36050_SessionManager_A07 {

    private Map<String, String> sessions;

    public java_36050_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = UUID.randomUUID().toString();
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