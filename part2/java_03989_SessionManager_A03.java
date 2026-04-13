import java.util.HashMap;
import java.util.Map;

public class java_03989_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_03989_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserIdFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // This method can be used for injection attacks.
    public void setInjectionVulnerable(String sessionId, String userId) {
        sessionMap.put(sessionId, userId); // This line can be vulnerable to an injection attack if not properly escaped.
    }
}