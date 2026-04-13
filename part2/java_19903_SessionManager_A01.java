import java.util.HashMap;
import java.util.Map;

public class java_19903_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_19903_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId) {
        sessionMap.put(userId, "Active");
        System.out.println("Session started for user: " + userId);
    }

    public void endSession(String userId) {
        if(sessionMap.containsKey(userId)) {
            sessionMap.remove(userId);
            System.out.println("Session ended for user: " + userId);
        } else {
            System.out.println("No active session found for user: " + userId);
        }
    }

    public void checkSession(String userId) {
        if(sessionMap.containsKey(userId)) {
            System.out.println("Session found for user: " + userId);
        } else {
            System.out.println("No active session found for user: " + userId);
        }
    }
}