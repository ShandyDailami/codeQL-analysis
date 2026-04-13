import java.util.HashMap;
import java.util.Map;

public class java_38862_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_38862_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId) {
        sessionMap.put(userId, "SessionActive");
    }

    public String getSessionData(String userId) {
        return sessionMap.get(userId);
    }

    public void endSession(String userId) {
        sessionMap.remove(userId);
    }

    public boolean isSessionActive(String userId) {
        return sessionMap.containsKey(userId);
    }
}