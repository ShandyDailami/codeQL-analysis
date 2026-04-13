import java.util.HashMap;
import java.util.Map;

public class java_05743_SessionManager_A08 {

    private Map<String, String> sessionMap;
    private static SessionManager instance;

    private java_05743_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public static SessionManager getInstance() {
        if(instance == null) {
            instance = new SessionManager();
        }
        return instance;
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

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}