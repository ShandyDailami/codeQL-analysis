import java.util.HashMap;
import java.util.Map;

public class java_39815_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_39815_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId) {
        sessionMap.put(userId, "active");
        System.out.println("Session started for user: " + userId);
    }

    public void endSession(String userId) {
        if (sessionMap.containsKey(userId)) {
            sessionMap.put(userId, "inactive");
            System.out.println("Session ended for user: " + userId);
        } else {
            System.out.println("No active session for user: " + userId);
        }
    }

    public String getSessionStatus(String userId) {
        if (sessionMap.containsKey(userId)) {
            return sessionMap.get(userId);
        } else {
            return "No active session for user: " + userId;
        }
    }
}