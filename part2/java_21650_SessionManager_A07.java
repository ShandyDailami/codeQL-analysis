import java.util.HashMap;
import java.util.Map;

public class java_21650_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_21650_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    public void startSession(String user, String sessionId) {
        sessionMap.put(sessionId, user);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public String getUser(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}