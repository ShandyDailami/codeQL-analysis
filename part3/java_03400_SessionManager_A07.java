import java.util.HashMap;
import java.util.Map;

public class java_03400_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_03400_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId) {
        sessionMap.put(userId, "Active");
    }

    public void endSession(String userId) {
        sessionMap.put(userId, "Inactive");
    }

    public String checkSession(String userId) {
        return sessionMap.get(userId);
    }

    public void validateSession(String userId) throws AuthFailure {
        if (!sessionMap.containsKey(userId) || !sessionMap.get(userId).equals("Active")) {
            throw new AuthFailure("Invalid session for user " + userId);
        }
    }
}