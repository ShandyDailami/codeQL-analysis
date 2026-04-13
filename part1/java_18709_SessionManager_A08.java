import java.util.HashMap;
import java.util.Map;

public class java_18709_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_18709_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId, String userId) {
        // Assuming that the sessionId is unique and the userId is not empty or null.
        // The sessionId will be used for identifying the user.
        // The userId will be used for authorization.
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        // Assuming that if the sessionId is not found in sessionMap, it means the session is invalid.
        return sessionMap.getOrDefault(sessionId, null);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}