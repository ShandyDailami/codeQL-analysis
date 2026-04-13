import java.util.HashMap;
import java.util.Map;

public class java_42097_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_42097_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId, String userId) {
        if(sessionMap.containsKey(sessionId)) {
            return "Session already exists";
        }
        sessionMap.put(sessionId, userId);
        return "Session created successfully";
    }

    public String getUserFromSession(String sessionId) {
        if(!sessionMap.containsKey(sessionId)) {
            return "Session does not exist";
        }
        return sessionMap.get(sessionId);
    }

    public String destroySession(String sessionId) {
        if(!sessionMap.containsKey(sessionId)) {
            return "Session does not exist";
        }
        sessionMap.remove(sessionId);
        return "Session destroyed successfully";
    }
}