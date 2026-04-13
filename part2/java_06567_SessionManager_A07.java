import java.util.HashMap;
import java.util.Map;

public class java_06567_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_06567_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String userName, String sessionId) {
        sessionMap.put(sessionId, userName);
    }

    public String getUserName(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}