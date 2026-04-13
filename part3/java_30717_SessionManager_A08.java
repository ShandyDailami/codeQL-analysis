import java.util.HashMap;
import java.util.Map;

public class java_30717_SessionManager_A08 {
    private Map<String, Object> sessionMap;

    public java_30717_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void put(String sessionId, Object sessionObject) {
        sessionMap.put(sessionId, sessionObject);
    }

    public Object get(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void remove(String sessionId) {
        sessionMap.remove(sessionId);
    }
}