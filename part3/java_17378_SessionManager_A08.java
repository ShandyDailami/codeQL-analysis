import java.util.HashMap;
import java.util.Map;

public class java_17378_SessionManager_A08 {
    private Map<String, Object> sessionMap;

    public java_17378_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void addSession(String sessionId, Object sessionObject) {
        sessionMap.put(sessionId, sessionObject);
    }

    public Object getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}