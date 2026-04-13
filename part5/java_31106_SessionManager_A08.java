import java.util.HashMap;
import java.util.Map;

public class java_31106_SessionManager_A08 {
    private Map<String, Session> sessions;

    public java_31106_SessionManager_A08() {
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
            session.close();
            sessions.remove(sessionId);
        }
    }

    private static class Session {
        private String id;

        public java_31106_SessionManager_A08(String id) {
            this.id = id;
        }

        public void close() {
            // Simulate a security-sensitive operation to close the session
            // Here, we assume that closing a session involves performing a complex operation that may fail
            try {
                // Perform a complex operation that may fail
                // We're simulating this with a dummy operation
                Thread.sleep(1000);
                System.out.println("Successfully closed session: " + id);
            } catch (InterruptedException e) {
                System.out.println("Failed to close session: " + id);
            }
        }
    }
}