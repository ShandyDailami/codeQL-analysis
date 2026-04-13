import java.util.HashMap;
import java.util.Map;

public class java_13007_SessionManager_A07 {
    private Map<String, String> sessions;

    public java_13007_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    public String createSession(String userName) {
        String sessionId = UUID.randomUUID().toString();
        sessions.put(sessionId, userName);
        return sessionId;
    }

    public String getUserName(String sessionId) {
        return sessions.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessions.remove(sessionId);
    }
}