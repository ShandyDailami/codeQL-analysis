import java.util.HashMap;
import java.util.Map;

public class java_37643_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_37643_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId) {
        sessionMap.put(userId, userId);
    }

    public String getSession(String userId) {
        if (sessionMap.containsKey(userId)) {
            return sessionMap.get(userId);
        } else {
            return null;
        }
    }

    public void endSession(String userId) {
        sessionMap.remove(userId);
    }
}