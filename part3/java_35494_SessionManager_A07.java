import java.util.HashMap;
import java.util.Map;

public class java_35494_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_35494_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId) {
        sessionMap.put(userId, "Active");
    }

    public void endSession(String userId) {
        sessionMap.put(userId, "Inactive");
    }

    public String checkSessionStatus(String userId) {
        return sessionMap.get(userId);
    }
}