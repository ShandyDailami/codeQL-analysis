import java.util.HashMap;
import java.util.Map;

public class java_01806_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_01806_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId) {
        sessionMap.put(userId, userId);
    }

    public String getSession(String userId) {
        return sessionMap.get(userId);
    }

    public void endSession(String userId) {
        sessionMap.remove(userId);
    }

    public boolean isValidSession(String userId) {
        return sessionMap.containsKey(userId);
    }
}