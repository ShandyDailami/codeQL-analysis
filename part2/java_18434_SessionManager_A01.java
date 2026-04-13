import java.util.HashMap;
import java.util.Map;

public class java_18434_SessionManager_A01 {
    private Map<String, String> sessions;

    public java_18434_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public void createSession(String userId) {
        String sessionId = userId + System.currentTimeMillis();
        sessions.put(userId, sessionId);
    }

    public void deleteSession(String userId) {
        sessions.remove(userId);
    }

    public String getSession(String userId) {
        return sessions.get(userId);
    }
}