import java.util.HashMap;
import java.util.Map;

public class java_31259_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_31259_SessionManager_A01() {
        this.sessionMap = new HashMap<>();
    }

    public void startSession(String userId) {
        if (!sessionMap.containsKey(userId)) {
            sessionMap.put(userId, "Active");
        } else {
            System.out.println("Session already exists for user: " + userId);
        }
    }

    public void endSession(String userId) {
        if (sessionMap.containsKey(userId)) {
            sessionMap.put(userId, "Inactive");
        } else {
            System.out.println("No session found for user: " + userId);
        }
    }

    public String getSessionStatus(String userId) {
        if (sessionMap.containsKey(userId)) {
            return sessionMap.get(userId);
        } else {
            return "No session found for user: " + userId;
        }
    }
}