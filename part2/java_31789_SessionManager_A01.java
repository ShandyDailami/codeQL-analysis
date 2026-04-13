import java.util.HashMap;
import java.util.Map;

public class java_31789_SessionManager_A01 {

    private Map<String, Object> sessionStorage;

    public java_31789_SessionManager_A01() {
        sessionStorage = new HashMap<>();
    }

    public void createSession(String sessionId, Object sessionObject) {
        sessionStorage.put(sessionId, sessionObject);
    }

    public Object getSession(String sessionId) {
        return sessionStorage.get(sessionId);
    }

    public void updateSession(String sessionId, Object sessionObject) {
        sessionStorage.put(sessionId, sessionObject);
    }

    public void deleteSession(String sessionId) {
        sessionStorage.remove(sessionId);
    }
}