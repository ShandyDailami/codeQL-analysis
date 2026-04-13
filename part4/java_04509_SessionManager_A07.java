import java.util.HashMap;
import java.util.Map;

public class java_04509_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_04509_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isSessionActive(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void updateUser(String oldSessionId, String newSessionId, String userId) {
        if (sessionMap.containsKey(oldSessionId)) {
            sessionMap.remove(oldSessionId);
            sessionMap.put(newSessionId, sessionMap.get(oldSessionId));
        }
    }
}