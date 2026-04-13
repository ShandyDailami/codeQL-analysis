import java.util.HashMap;
import java.util.Map;

public class java_20936_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_20936_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId) {
        sessionMap.put(userId, "Active");
    }

    public void endSession(String userId) {
        sessionMap.put(userId, "Inactive");
    }

    public String getSessionState(String userId) {
        return sessionMap.get(userId);
    }

    public void checkSession(String userId) throws Exception {
        if (sessionMap.get(userId) == null) {
            throw new Exception("User is not logged in.");
        }
    }
}