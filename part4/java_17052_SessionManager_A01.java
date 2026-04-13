import java.util.HashMap;
import java.util.Map;

public class java_17052_SessionManager_A01 {
    private Map<String, String> sessions;

    public java_17052_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        sessions.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessions.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessions.remove(sessionId);
    }
}