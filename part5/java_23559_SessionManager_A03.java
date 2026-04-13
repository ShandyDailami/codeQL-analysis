import java.util.HashMap;
import java.util.Map;

public class java_23559_SessionManager_A03 {

    // Use a HashMap to store session data
    private Map<String, String> sessionData = new HashMap<>();

    // Constructor
    public java_23559_SessionManager_A03() {
        sessionData.put("sessionId", "123");
        sessionData.put("userId", "456");
    }

    // Method to get session data
    public String getSessionData(String sessionId) {
        // Check if sessionId is valid
        if (sessionId != null && sessionId.equals(sessionData.get("sessionId"))) {
            return sessionData.get("userId");
        }
        return null;
    }

    // Method to update session data
    public void updateSessionData(String userId) {
        // Check if userId is valid
        if (userId != null && userId.equals(sessionData.get("userId"))) {
            sessionData.put("userId", userId);
        }
    }
}