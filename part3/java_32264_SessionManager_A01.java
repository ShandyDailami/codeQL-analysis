import java.util.HashMap;
import java.util.Map;

public class java_32264_SessionManager_A01 {

    private Map<String, String> sessionMap;

    public java_32264_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String userId, String sessionId) {
        sessionMap.put(userId, sessionId);
    }

    public String getSession(String userId) {
        if(sessionMap.containsKey(userId)) {
            return sessionMap.get(userId);
        } else {
            throw new IllegalArgumentException("No session found for user: " + userId);
        }
    }

    public void deleteSession(String userId) {
        sessionMap.remove(userId);
    }

    public void validateSession(String userId, String sessionId) {
        if(!sessionMap.containsKey(userId) || !sessionMap.get(userId).equals(sessionId)) {
            throw new SecurityException("Invalid session: " + sessionId + " for user: " + userId);
        }
    }
}