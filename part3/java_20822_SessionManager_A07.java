import java.util.HashMap;
import java.util.Map;

public class java_20822_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_20822_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId) {
        if (!sessionMap.containsKey(userId)) {
            sessionMap.put(userId, "Active");
            System.out.println("Session started for user: " + userId);
        } else {
            System.out.println("Session already started for user: " + userId);
        }
    }

    public void endSession(String userId) {
        if (sessionMap.containsKey(userId)) {
            sessionMap.put(userId, "Inactive");
            System.out.println("Session ended for user: " + userId);
        } else {
            System.out.println("No session started for user: " + userId);
        }
    }

    public String getSessionStatus(String userId) {
        return sessionMap.get(userId);
    }
}