import java.util.HashMap;
import java.util.Map;

public class java_33375_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_33375_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId) {
        sessionMap.put(userId, "Active");
    }

    public void endSession(String userId) {
        if (sessionMap.containsKey(userId)) {
            sessionMap.remove(userId);
        }
    }

    public String getSessionStatus(String userId) {
        return sessionMap.getOrDefault(userId, "Inactive");
    }

    public void checkSessionIntegrity() {
        for (Map.Entry<String, String> entry : sessionMap.entrySet()) {
            if (entry.getValue().equals("Inactive")) {
                System.out.println("IntegrityFailure: User with ID " + entry.getKey() + " has ended their session, but there is a stale session record.");
            }
        }
    }
}