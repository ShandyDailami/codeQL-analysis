import java.util.HashMap;
import java.util.Map;

public class java_33967_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_33967_SessionManager_A01() {
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

    public void checkAccess(String userId) {
        String sessionStatus = sessionMap.get(userId);
        if (sessionStatus == null || sessionStatus.equals("Inactive")) {
            throw new IllegalStateException("Access Denied: Session is Inactive for user: " + userId);
        }
    }
}