import java.util.HashMap;
import java.util.Map;

public class java_15432_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_15432_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void addSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}