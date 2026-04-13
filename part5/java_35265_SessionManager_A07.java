import java.util.HashMap;
import java.util.Map;

public class java_35265_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_35265_SessionManager_A07() {
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

    public boolean isSessionValid(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void clearAllSessions() {
        sessionMap.clear();
    }
}