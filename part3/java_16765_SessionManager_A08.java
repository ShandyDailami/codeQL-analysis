import java.util.HashMap;
import java.util.Map;

public class java_16765_SessionManager_A08 {

    // Create a map to store session id and object instances
    private Map<String, Object> sessionMap;

    public java_16765_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, Object object) {
        sessionMap.put(sessionId, object);
    }

    public Object getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void updateSession(String sessionId, Object object) {
        sessionMap.put(sessionId, object);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}