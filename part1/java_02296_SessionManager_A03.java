import java.util.HashMap;
import java.util.Map;

public class java_02296_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_02296_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userName) {
        sessionMap.put(sessionId, userName);
    }

    public String getUserName(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}