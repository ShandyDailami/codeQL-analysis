import java.util.HashMap;
import java.util.Map;

public class java_04253_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_04253_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId) {
        sessionMap.put(userId, "Active");
        System.out.println("Session started for user: " + userId);
    }

    public void endSession(String userId) {
        if (sessionMap.containsKey(userId)) {
            sessionMap.put(userId, "Inactive");
            System.out.println("Session ended for user: " + userId);
        } else {
            System.out.println("No active session found for user: " + userId);
        }
    }

    public void checkSession(String userId) {
        if (sessionMap.containsKey(userId)) {
            if ("Active".equals(sessionMap.get(userId))) {
                System.out.println("User: " + userId + " is currently logged in.");
            } else {
                System.out.println("User: " + userId + " is not currently logged in.");
            }
        } else {
            System.out.println("No active session found for user: " + userId);
        }
    }
}