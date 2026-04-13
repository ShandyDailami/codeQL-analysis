import java.util.HashMap;
import java.util.Map;

public class java_28685_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_28685_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId) {
        sessionMap.put(userId, "Active");
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

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.startSession("user1");
        sessionManager.startSession("user2");
        sessionManager.endSession("user1");
        sessionManager.endSession("user3");
    }
}