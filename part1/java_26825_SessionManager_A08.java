import java.util.HashMap;
import java.util.Map;

public class java_26825_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_26825_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId) {
        // Here you would typically store the session ID in the session map
        sessionMap.put(userId, "session");
    }

    public void endSession(String userId) {
        // Here you would typically remove the session ID from the session map
        sessionMap.remove(userId);
    }

    public String getSession(String userId) {
        // Here you would typically return the session ID from the session map
        return sessionMap.get(userId);
    }
}