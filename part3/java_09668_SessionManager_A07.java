import java.util.HashMap;
import java.util.Map;

public class java_09668_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_09668_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userName) {
        sessionMap.put(sessionId, userName);
    }

    public String getUserFromSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        }
        return null;
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}