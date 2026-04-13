import java.util.HashMap;
import java.util.Map;

public class java_24467_SessionManager_A03 {

    private Map<String, Object> sessionMap;

    public java_24467_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void openSession(String sessionId, Object sessionObject) {
        sessionMap.put(sessionId, sessionObject);
    }

    public Object getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void closeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void updateSession(String sessionId, Object sessionObject) {
        sessionMap.put(sessionId, sessionObject);
    }
}