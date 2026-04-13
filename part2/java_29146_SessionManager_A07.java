import java.util.HashMap;
import java.util.Map;

public class java_29146_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_29146_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void updateUser(String oldSessionId, String newSessionId, String userId) {
        if (isValidSession(oldSessionId)) {
            endSession(oldSessionId);
            createSession(newSessionId, userId);
        } else if (isValidSession(newSessionId)) {
            endSession(newSessionId);
            createSession(newSessionId, userId);
        }
    }
}