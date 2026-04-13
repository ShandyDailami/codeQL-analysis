import java.util.HashMap;
import java.util.Map;

public class java_27240_SessionManager_A01 {
    // Create a map to store sessions
    private Map<String, Session> sessionMap;

    public java_27240_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Create a session
    public Session createSession(String userId) {
        Session session = new Session(userId);
        sessionMap.put(userId, session);
        return session;
    }

    // Get a session
    public Session getSession(String userId) {
        return sessionMap.get(userId);
    }

    // Close a session
    public void closeSession(String userId) {
        sessionMap.remove(userId);
    }

    // Session class
    public class Session {
        private String userId;

        public java_27240_SessionManager_A01(String userId) {
            this.userId = userId;
        }

        // Methods for session
    }
}