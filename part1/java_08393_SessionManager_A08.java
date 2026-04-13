import java.util.HashMap;
import java.util.Map;

public class java_08393_SessionManager_A08 {
    private Map<String, Object> sessionMap;

    public java_08393_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, Object sessionObject) {
        sessionMap.put(sessionId, sessionObject);
    }

    public Object getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void updateSession(String sessionId, Object sessionObject) {
        sessionMap.put(sessionId, sessionObject);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}