import java.util.HashMap;
import java.util.Map;

public class java_26526_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_26526_SessionManager_A03() {
        this.sessionMap = new HashMap<>();
    }

    public void openSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void closeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}