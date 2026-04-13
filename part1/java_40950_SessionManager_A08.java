import java.util.HashMap;
import java.util.Map;

public class java_40950_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_40950_SessionManager_A08() {
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

    public void deleteAllSessions() {
        sessionMap.clear();
    }
}