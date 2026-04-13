import java.util.HashMap;
import java.util.Map;

public class java_18846_SessionManager_A03 {

    private Map<String, String> sessionMap;

    public java_18846_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userName) {
        sessionMap.put(sessionId, userName);
    }

    public String getUserName(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isSessionExists(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}