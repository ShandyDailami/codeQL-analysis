import java.util.HashMap;
import java.util.Map;

public class java_22778_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_22778_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void addSession(String userId, String sessionId) {
        sessionMap.put(userId, sessionId);
    }

    public String getSession(String userId) {
        return sessionMap.get(userId);
    }

    public void removeSession(String userId) {
        sessionMap.remove(userId);
    }
}