import java.util.HashMap;
import java.util.Map;

public class java_35826_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_35826_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userID) {
        sessionMap.put(userID, "Active");
    }

    public void endSession(String userID) {
        sessionMap.put(userID, "Inactive");
    }

    public String getSessionStatus(String userID) {
        return sessionMap.get(userID);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.startSession("user1");
        System.out.println(sessionManager.getSessionStatus("user1")); // Outputs: Active
        sessionManager.endSession("user1");
        System.out.println(sessionManager.getSessionStatus("user1")); // Outputs: Inactive
    }
}