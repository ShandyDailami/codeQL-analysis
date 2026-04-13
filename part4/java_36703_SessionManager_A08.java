import java.util.HashMap;
import java.util.Map;

public class java_36703_SessionManager_A08 {

    private Map<String, String> sessions;

    public java_36703_SessionManager_A08() {
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

    public boolean isValidSession(String userId, String sessionId) {
        return sessions.containsKey(userId) && sessions.get(userId).equals(sessionId);
    }
}