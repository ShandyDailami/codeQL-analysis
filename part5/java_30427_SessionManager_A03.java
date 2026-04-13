import java.util.HashMap;
import java.util.Map;

public class java_30427_SessionManager_A03 {

    // Use a private static Map to store the sessions.
    private static Map<String, String> sessionMap;

    // Use a private static SessionManager instance to handle the session.
    private static SessionManager sessionManager;

    // Private constructor to restrict the creation of a SessionManager.
    private java_30427_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Singleton design pattern to ensure that only one SessionManager instance is created.
    public static SessionManager getSessionManager() {
        if (sessionManager == null) {
            sessionManager = new SessionManager();
        }
        return sessionManager;
    }

    // Method to add a session.
    public void addSession(String sessionId, String sessionValue) {
        sessionMap.put(sessionId, sessionValue);
    }

    // Method to retrieve a session.
    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to remove a session.
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}