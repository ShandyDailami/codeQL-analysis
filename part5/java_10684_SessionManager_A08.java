import java.util.HashMap;
import java.util.Map;

public class java_10684_SessionManager_A08 {

    // Private static map to hold session data
    private static Map<String, Session> sessionMap;

    // Initialize the static map
    static {
        sessionMap = new HashMap<>();
    }

    // Private constructor to restrict instantiation
    private java_10684_SessionManager_A08() {
        throw new UnsupportedOperationException("Instantiation not allowed");
    }

    // Public method to create a new session
    public static Session createSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            throw new SecurityException("Session already exists with ID: " + sessionId);
        }

        Session session = new Session(sessionId);
        sessionMap.put(sessionId, session);

        return session;
    }

    // Public method to retrieve a session
    public static Session getSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new SecurityException("No session found with ID: " + sessionId);
        }

        return sessionMap.get(sessionId);
    }

    // Public method to invalidate a session
    public static void invalidateSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new SecurityException("No session found with ID: " + sessionId);
        }

        sessionMap.remove(sessionId);
    }

    // Session class
    public static class Session {
        private String sessionId;

        public java_10684_SessionManager_A08(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }
    }
}