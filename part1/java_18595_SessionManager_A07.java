import java.util.HashMap;
import java.util.Map;

public class java_18595_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_18595_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username) {
        sessionMap.put(username, "Session started");
    }

    public void endSession(String username) {
        sessionMap.remove(username);
    }

    public String getSessionStatus(String username) {
        if (sessionMap.containsKey(username)) {
            return sessionMap.get(username);
        } else {
            return "No active session found for user: " + username;
        }
    }
}