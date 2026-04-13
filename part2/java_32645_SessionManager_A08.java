import java.util.HashMap;
import java.util.Map;

public class java_32645_SessionManager_A08 {
    private Map<String, Object> sessionMap;

    public java_32645_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, Object sessionObject) {
        sessionMap.put(sessionId, sessionObject);
    }

    public Object getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}