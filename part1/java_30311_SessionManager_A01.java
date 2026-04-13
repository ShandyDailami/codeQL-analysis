import java.util.HashMap;
import java.util.Map;

public class java_30311_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_30311_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId) {
        sessionMap.put(userId, "Active");
    }

    public void endSession(String userId) {
        sessionMap.put(userId, "Inactive");
    }

    public String getSessionStatus(String userId) {
        return sessionMap.get(userId);
    }
}