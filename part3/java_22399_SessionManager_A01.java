import java.util.HashMap;
import java.util.Map;

public class java_22399_SessionManager_A01 {
    private Map<String, String> sessions;

    public java_22399_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public void startSession(String userId, String sessionId) {
        sessions.put(userId, sessionId);
    }

    public String getSession(String userId) {
        return sessions.get(userId);
    }

    public void endSession(String userId) {
        sessions.remove(userId);
    }
}