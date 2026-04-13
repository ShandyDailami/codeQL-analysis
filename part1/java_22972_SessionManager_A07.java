import java.util.HashMap;
import java.util.Map;

public class java_22972_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_22972_SessionManager_A07() {
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