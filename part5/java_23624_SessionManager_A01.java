import java.util.HashMap;
import java.util.Map;

public class java_23624_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_23624_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId, String sessionId) {
        if (sessionMap.containsKey(userId)) {
            System.out.println("Session already exists for user: " + userId);
        } else {
            sessionMap.put(userId, sessionId);
            System.out.println("Session started for user: " + userId);
        }
    }

    public void endSession(String userId) {
        if (sessionMap.containsKey(userId)) {
            sessionMap.remove(userId);
            System.out.println("Session ended for user: " + userId);
        } else {
            System.out.println("No session exists for user: " + userId);
        }
    }

    public void accessSystem(String userId) {
        if (sessionMap.containsKey(userId)) {
            System.out.println("Access granted for user: " + userId);
        } else {
            System.out.println("Access denied for user: " + userId);
        }
    }
}