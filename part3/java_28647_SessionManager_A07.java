import java.util.HashMap;
import java.util.Map;

public class java_28647_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_28647_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    public void startSession(String userId) {
        sessionMap.put(userId, "active");
        System.out.println("Session started for user: " + userId);
    }

    public void endSession(String userId) {
        if (sessionMap.containsKey(userId)) {
            sessionMap.remove(userId);
            System.out.println("Session ended for user: " + userId);
        } else {
            System.out.println("No active session found for user: " + userId);
        }
    }

    public String getSessionStatus(String userId) {
        if (sessionMap.containsKey(userId)) {
            return sessionMap.get(userId);
        } else {
            return "No active session found";
        }
    }
}