import java.util.HashMap;
import java.util.Map;

public class java_04929_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_04929_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId, String sessionId) {
        sessionMap.put(userId, sessionId);
    }

    public String getSession(String userId) {
        if (sessionMap.containsKey(userId)) {
            return sessionMap.get(userId);
        } else {
            return null;
        }
    }

    public void endSession(String userId) {
        if (sessionMap.containsKey(userId)) {
            sessionMap.remove(userId);
        }
    }

    public boolean isValidSession(String userId, String sessionId) {
        if (sessionMap.containsKey(userId)) {
            return sessionMap.get(userId).equals(sessionId);
        } else {
            return false;
        }
    }

}