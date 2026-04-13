import java.util.HashMap;
import java.util.Map;

public class java_05339_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_05339_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId() {
        // This method can be implemented to generate a secure session id,
        // such as UUID or a combination of user id and current timestamp
        return "SESSION_ID";
    }

    public void checkSessionIntegrity(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new SecurityException("Session integrity failure: Session id does not exist");
        }
    }
}