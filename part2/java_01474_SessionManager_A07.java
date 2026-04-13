import java.util.HashMap;
import java.util.Map;

public class java_01474_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_01474_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId) {
        if (sessionMap.containsKey(userId)) {
            System.out.println("Session already exists for user: " + userId);
        } else {
            sessionMap.put(userId, "active");
            System.out.println("Session started for user: " + userId);
        }
    }

    public void endSession(String userId) {
        if (sessionMap.containsKey(userId)) {
            sessionMap.put(userId, "inactive");
            System.out.println("Session ended for user: " + userId);
        } else {
            System.out.println("No session found for user: " + userId);
        }
    }

    public String getSessionStatus(String userId) {
        return sessionMap.get(userId);
    }
}