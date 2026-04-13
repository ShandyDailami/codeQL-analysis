import java.util.HashMap;
import java.util.Map;

public class java_07253_SessionManager_A03 {

    private Map<String, String> sessionMap;

    public java_07253_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = userId + System.nanoTime();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Security sensitive method, userId should not be directly available
    // for session creation.
    public void createSessionForSecurity(String userId) {
        // The userId here is not considered security sensitive, as it's not directly available
        // for session creation. This is just a demonstration of how A03_Injection could be implemented
        // in a legacy style. In a real-world application, it's not recommended to directly use userId
        // for session creation, as userId should not be directly available.
    }
}