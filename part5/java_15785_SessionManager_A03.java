// START OF CODE

import java.util.HashMap;
import java.util.Map;

public class java_15785_SessionManager_A03 {

    private Map<String, String> sessionMap;

    public java_15785_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isSessionValid(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void updateSession(String sessionId, String newUserId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.replace(sessionId, newUserId);
        }
    }
}

// END OF CODE