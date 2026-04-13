import java.util.HashMap;
import java.util.Map;

public class java_16707_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_16707_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId, String user) {
        sessionMap.put(sessionId, user);
        return sessionId;
    }

    public String getUser(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}