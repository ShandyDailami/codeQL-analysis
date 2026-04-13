import java.util.HashMap;
import java.util.Map;

public class java_32348_SessionManager_A01 {
    private Map<String, String> sessions;

    public java_32348_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public void createSession(String userId, String sessionId) {
        sessions.put(userId, sessionId);
    }

    public String getSession(String userId) {
        return sessions.get(userId);
    }

    public void deleteSession(String userId) {
        sessions.remove(userId);
    }

    public boolean isSessionExists(String userId) {
        return sessions.containsKey(userId);
    }

    public void clearAllSessions() {
        sessions.clear();
    }
}