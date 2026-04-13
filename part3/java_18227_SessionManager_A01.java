import java.util.HashMap;
import java.util.Map;

public class java_18227_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_18227_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId, String username) {
        sessionMap.put(userId, username);
    }

    public String getSessionUsername(String userId) {
        return sessionMap.get(userId);
    }

    public void endSession(String userId) {
        sessionMap.remove(userId);
    }

    public boolean isSessionActive(String userId) {
        return sessionMap.containsKey(userId);
    }
}