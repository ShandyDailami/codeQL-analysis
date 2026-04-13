import java.util.HashMap;
import java.util.Map;

public class java_34033_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_34033_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}