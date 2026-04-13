import java.util.HashMap;

public class java_08958_SessionManager_A08 {
    private HashMap<String, Session> sessions;

    public java_08958_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public Session getSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session == null) {
            session = new Session(sessionId);
            sessions.put(sessionId, session);
        }
        return session;
    }

    public void closeSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session != null) {
            sessions.remove(sessionId);
       
        }
    }

    public class Session {
        private String sessionId;

        public java_08958_SessionManager_A08(String sessionId) {
            this.sessionId = sessionId;
        }

        public void setAttribute(String name, Object value) {
            // This is where you might add some security-sensitive operations, such as encryption
            // But for the sake of simplicity, we'll leave it out for this example
        }

        public Object getAttribute(String name) {
            // This is where you might add some security-sensitive operations, such as decryption
            // But for the sake of simplicity, we'll leave it out for this example
            return null;
        }
    }
}