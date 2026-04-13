import java.util.HashMap;
import java.util.Map;

public class java_41659_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_41659_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userName) {
        sessionMap.put(sessionId, userName);
    }

    public String getUserName(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}