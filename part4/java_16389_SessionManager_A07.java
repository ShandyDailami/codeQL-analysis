import java.util.HashMap;
import java.util.Map;

public class java_16389_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_16389_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public boolean isValidUser(String userId) {
        for(Map.Entry<String, String> entry: sessionMap.entrySet()) {
            if(entry.getValue().equals(userId)) {
                return true;
            }
        }
        return false;
    }

    public boolean isValidUser(String sessionId, String userId) {
        if(sessionMap.containsKey(sessionId)) {
            if(sessionMap.get(sessionId).equals(userId)) {
                return true;
            }
        }
        return false;
    }
}