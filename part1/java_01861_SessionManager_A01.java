import java.util.HashMap;
import java.util.Map;

public class java_01861_SessionManager_A01 {

    // private instance of the session manager
    private static SessionManager sessionManager = null;

    // private instance of the session map
    private Map<String, String> sessionMap;

    // private constructor to restrict the creation of new SessionManager instances
    private java_01861_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // public static method to get the single instance of the SessionManager
    public static SessionManager getSessionManager() {
        if (sessionManager == null) {
            sessionManager = new SessionManager();
        }
        return sessionManager;
    }

    // method to create a new session
    public String createSession(String sessionId) {
        sessionMap.put(sessionId, sessionId);
        return sessionId;
    }

    // method to get the session by session id
    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // method to delete a session
    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}