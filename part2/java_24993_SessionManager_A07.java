import java.util.HashMap;
import java.util.Map;

public class java_24993_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_24993_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    public void startSession(String userId, String sessionId) {
        sessionMap.put(userId, sessionId);
    }

    public String getSessionId(String userId) {
        return sessionMap.get(userId);
    }

    public void endSession(String userId) {
        sessionMap.remove(userId);
    }

    public boolean isValidUser(String userId, String sessionId) {
        String storedSessionId = sessionMap.get(userId);
        return storedSessionId != null && storedSessionId.equals(sessionId);
    }

    public void invalidateAllSessions(String userId) {
        sessionMap.remove(userId);
    }
}