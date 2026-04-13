import java.util.HashMap;
import java.util.Map;

public class java_38724_SessionManager_A03 {

    private Map<String, Object> sessionMap;

    public java_38724_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void addSession(String sessionId, Object session) {
        sessionMap.put(sessionId, session);
    }

    public Object getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}