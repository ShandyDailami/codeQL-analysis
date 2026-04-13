import java.util.HashMap;
import java.util.Map;

public class java_29487_SessionManager_A08 {
    private Map<String, Session> sessions;

    public java_29487_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public Session getSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return sessions.get(sessionId);
        } else {
            Session newSession = new Session(sessionId);
            sessions.put(sessionId, newSession);
            return newSession;
        }
    }

    public void closeSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            sessions.remove(sessionId);
        }
    }

    private class Session {
        private String sessionId;

        public java_29487_SessionManager_A08(String sessionId) {
            this.sessionId = sessionId;
        }

        public void setAttribute(String name, Object value) {
            // Implementation of setAttribute to handle integrity failure
            // Here we just log it and fail silently
            System.out.println("Setting attribute: " + name + " = " + value + " (SessionId: " + sessionId + ")");
        }

        public Object getAttribute(String name) {
            // Implementation of getAttribute to handle integrity failure
            // Here we just return null and fail silently
            System.out.println("Getting attribute: " + name + " (SessionId: " + sessionId + ")");
            return null;
        }

        public void close() {
            // Implementation of close to handle integrity failure
            // Here we just log it and fail silently
            System.out.println("Closing session: " + sessionId);
        }
    }
}