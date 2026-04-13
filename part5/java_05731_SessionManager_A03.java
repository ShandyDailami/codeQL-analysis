import java.util.HashMap;
import java.util.Map;

public class java_05731_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_05731_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void addSession(String sessionId, String sessionValue) {
        sessionMap.put(sessionId, sessionValue);
    }

    public String getSessionValue(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}