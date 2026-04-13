import java.util.HashMap;
import java.util.Map;

public class java_05273_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_05273_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String user) {
        sessionMap.put(sessionId, user);
    }

    public String getUserBySessionId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}