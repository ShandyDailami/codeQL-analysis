import java.util.HashMap;
import java.util.Map;

public class java_09057_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_09057_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String user, String sessionId) {
        sessionMap.put(sessionId, user);
    }

    public String getUser(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void invalidateSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}