import java.util.HashMap;
import java.util.Map;

public class java_36542_SessionManager_A03 {
    private Map<String, String> sessionData;

    public java_36542_SessionManager_A03() {
        sessionData = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionData.put(sessionId, userId);
    }

    public String getUserIdFromSession(String sessionId) {
        return sessionData.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessionData.remove(sessionId);
    }
}