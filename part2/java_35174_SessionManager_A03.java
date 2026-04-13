import java.util.HashMap;
import java.util.Map;

public class java_35174_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_35174_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String user) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, user);
        return sessionId;
    }

    public String getUser(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}