import java.util.HashMap;
import java.util.Map;

public class java_04845_SessionManager_A01 {

    private Map<String, String> sessionMap;

    public java_04845_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserFromSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null; // or throw an exception, or return a default value, or do nothing
        }
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}