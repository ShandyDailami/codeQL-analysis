import java.util.HashMap;
import java.util.Map;

public class java_34902_SessionManager_A07 {
    private Map<String, String> sessions;

    public java_34902_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    public void startSession(String userId) {
        sessions.put(userId, "Active");
    }

    public void endSession(String userId) {
        sessions.put(userId, "Inactive");
    }

    public String getSessionStatus(String userId) {
        if (sessions.containsKey(userId)) {
            return sessions.get(userId);
        } else {
            return "No session found for the user";
        }
    }
}