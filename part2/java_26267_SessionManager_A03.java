import java.util.HashMap;
import java.util.Map;

public class java_26267_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_26267_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userName) {
        sessionMap.put(sessionId, userName);
    }

    public String getUserName(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null;
        }
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}