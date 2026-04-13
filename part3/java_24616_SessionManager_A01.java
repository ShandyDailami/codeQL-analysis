import java.util.HashMap;
import java.util.Map;

public class java_24616_SessionManager_A01 {

    private Map<String, String> sessionMap;

    public java_24616_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId) {
        sessionMap.put(userId, "SessionActive");
        System.out.println("Session started for user: " + userId);
    }

    public void endSession(String userId) {
        sessionMap.remove(userId);
        System.out.println("Session ended for user: " + userId);
    }

    public void checkSession(String userId) {
        if (sessionMap.containsKey(userId)) {
            System.out.println("Session active for user: " + userId);
        } else {
            System.out.println("No active session for user: " + userId);
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.startSession("user1");
        sessionManager.checkSession("user1");
        sessionManager.endSession("user1");
        sessionManager.checkSession("user1");
    }
}