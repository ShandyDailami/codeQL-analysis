import java.util.HashMap;
import java.util.Map;

public class java_36643_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_36643_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId, String sessionId) {
        if (sessionMap.containsKey(userId)) {
            throw new IllegalStateException("User already has a session.");
        }
        sessionMap.put(userId, sessionId);
    }

    public String getSession(String userId) {
        if (!sessionMap.containsKey(userId)) {
            throw new IllegalStateException("User does not have a session.");
        }
        return sessionMap.get(userId);
    }

    public void endSession(String userId) {
        if (!sessionMap.containsKey(userId)) {
            throw new IllegalStateException("User does not have a session.");
        }
        sessionMap.remove(userId);
    }
}