import java.util.HashMap;
import java.util.Map;

public class java_00326_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_00326_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId) {
        sessionMap.put(userId, "Session Started");
    }

    public void endSession(String userId) {
        sessionMap.remove(userId);
   
        if (sessionMap.isEmpty()) {
            System.out.println("All Sessions Ended");
        }
    }

    public void printSessionStatus() {
        for (Map.Entry<String, String> entry : sessionMap.entrySet()) {
            System.out.println("User ID: " + entry.getKey() + ", Session Status: " + entry.getValue());
        }
    }
}