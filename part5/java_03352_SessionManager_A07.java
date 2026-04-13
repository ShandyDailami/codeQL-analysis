import java.util.HashMap;
import java.util.Map;

public class java_03352_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_03352_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId) {
        sessionMap.put(userId, "Active");
    }

    public void endSession(String userId) {
        sessionMap.put(userId, "Inactive");
    }

    public String getSessionStatus(String userId) {
        return sessionMap.get(userId);
    }

    public void checkSession(String userId) {
        if (sessionMap.get(userId) == null) {
            System.out.println("Session not found for user: " + userId);
        } else {
            System.out.println("Session found for user: " + userId);
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.startSession("user1");
        sessionManager.checkSession("user1");
        sessionManager.endSession("user1");
        sessionManager.checkSession("user2");
    }
}