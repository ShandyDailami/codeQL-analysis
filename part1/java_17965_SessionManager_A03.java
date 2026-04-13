import java.util.HashMap;
import java.util.Map;

public class java_17965_SessionManager_A03 {

    // This is a simple HashMap for demonstration purposes. 
    // Normally, the HashMap would be much more complex and secure.
    private Map<String, String> sessionMap = new HashMap<>();

    // Injecting sessionId and userId as parameters
    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Injecting sessionId, userId and userRoles as parameters
    public void updateSession(String sessionId, String userId, String... userRoles) {
        sessionMap.put(sessionId, userId);
    }

    // Injecting sessionId as parameters
    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}