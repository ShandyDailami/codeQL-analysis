import java.util.HashMap;
import java.util.Map;

public class java_32303_SessionManager_A08 {
    // In a real application, this would be a private static instance
    private static SessionManager instance;

    private Map<String, String> sessionMap;

    private java_32303_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public void startSession(String sessionId) {
        sessionMap.put(sessionId, sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public boolean isSessionValid(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}