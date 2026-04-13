import java.util.HashMap;
import java.util.Map;

public class java_02561_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_02561_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = String.valueOf(System.currentTimeMillis()); // Assuming session IDs are unique and random
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.getOrDefault(sessionId, null);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}