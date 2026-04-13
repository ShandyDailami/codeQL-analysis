import java.util.HashMap;
import java.util.Map;

public class java_04260_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_04260_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        // This is a security-sensitive operation related to A03_Injection
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}