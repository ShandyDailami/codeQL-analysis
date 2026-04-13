import java.util.HashMap;
import java.util.Map;

public class java_40297_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_40297_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String userName, String sessionId) {
        sessionMap.put(sessionId, userName);
    }

    public String getUserNameBySessionId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}