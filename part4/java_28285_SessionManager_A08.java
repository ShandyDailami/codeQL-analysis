import java.util.HashMap;
import java.util.Map;

public class java_28285_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_28285_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String userId, String sessionId) {
        sessionMap.put(userId, sessionId);
    }

    public String getSession(String userId) {
        return sessionMap.get(userId);
    }

    public void deleteSession(String userId) {
        sessionMap.remove(userId);
    }

    // For demonstration purposes only, the integrity check is not implemented here
    public boolean integrityCheck(String userId, String sessionId) {
        return sessionMap.containsKey(userId) && sessionMap.get(userId).equals(sessionId);
    }

    // For demonstration purposes only, the integrity failure is not implemented here
    public void integrityFailure() {
        sessionMap.clear();
    }
}