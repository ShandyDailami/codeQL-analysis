import java.util.HashMap;
import java.util.Map;

public class java_06164_SessionManager_A08 {

    private Map<String, String> sessionMap;
    private Map<String, String> userMap;

    public java_06164_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
        this.userMap = new HashMap<>();
    }

    public String createSession(String userId) {
        if (userMap.containsKey(userId)) {
            throw new SecurityException("User already exists");
        }

        String sessionId = String.valueOf(sessionMap.size() + 1);
        sessionMap.put(sessionId, userId);
        userMap.put(userId, sessionId);
        return sessionId;
    }

    public String getUserFromSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new SecurityException("Invalid session");
        }

        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new SecurityException("Invalid session");
        }

        String userId = sessionMap.get(sessionId);
        sessionMap.remove(sessionId);
        userMap.remove(userId);
    }
}