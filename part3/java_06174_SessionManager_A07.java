import java.util.HashMap;
import java.util.Map;

public class java_06174_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_06174_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId) {
        sessionMap.put(userId, "Session started");
    }

    public void endSession(String userId) {
        sessionMap.remove(userId);
    }

    public String getSessionStatus(String userId) {
        return sessionMap.getOrDefault(userId, "No session found");
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.startSession("user1");
        System.out.println(sessionManager.getSessionStatus("user1"));

        sessionManager.startSession("user2");
        System.out.println(sessionManager.getSessionStatus("user2"));

        sessionManager.endSession("user1");
        System.out.println(sessionManager.getSessionStatus("user1"));
    }
}