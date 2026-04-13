import java.util.HashMap;
import java.util.Map;

public class java_15010_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_15010_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId) {
        // This is a security sensitive operation, so we'll use a simple hash as the session key
        sessionMap.put(userId, userId);
    }

    public String getSession(String userId) {
        // This is a security sensitive operation, so we'll use a simple hash as the session key
        return sessionMap.get(userId);
    }

    public void endSession(String userId) {
        // This is a security sensitive operation, so we'll use a simple hash as the session key
        sessionMap.remove(userId);
    }
}