import java.util.HashMap;
import java.util.Map;

public class java_01242_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_01242_SessionManager_A01() {
        this.sessionMap = new HashMap<>();
    }

    public void startSession(String userName, String sessionId) {
        sessionMap.put(sessionId, userName);
    }

    public String getUserName(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isSessionActive(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}