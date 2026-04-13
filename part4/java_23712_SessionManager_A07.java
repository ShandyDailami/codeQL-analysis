import java.util.HashMap;
import java.util.Map;

public class java_23712_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_23712_SessionManager_A07() {
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

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.startSession("user1");
        System.out.println(sessionManager.getSessionStatus("user1")); // Outputs: Active
        sessionManager.endSession("user1");
        System.out.println(sessionManager.getSessionStatus("user1")); // Outputs: Inactive
    }
}