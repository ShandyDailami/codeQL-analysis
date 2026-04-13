import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class java_01456_SessionManager_A03 {
    private Map<String, Object> sessionMap;

    public java_01456_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String createSession(Object data) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, data);
        return sessionId;
    }

    public Object getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void updateSession(String sessionId, Object data) {
        sessionMap.put(sessionId, data);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}