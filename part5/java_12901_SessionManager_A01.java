import java.util.HashMap;
import java.util.Map;

public class java_12901_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_12901_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void openSession(String sessionId, String user) {
        sessionMap.put(sessionId, user);
    }

    public void closeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public String getUser(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}