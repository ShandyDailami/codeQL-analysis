import javax.management.RuntimeMBeanException;
import java.util.HashMap;
import java.util.Map;

public class java_21014_SessionManager_A08 {
    private Map<String, Session> sessions;

    public java_21014_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public Session getSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return sessions.get(sessionId);
        } else {
            throw new RuntimeMBeanException("No session found with id " + sessionId);
        }
    }

    public Session createSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            throw new RuntimeMBeanException("Session with id " + sessionId + " already exists");
        } else {
            Session session = new Session(sessionId);
            sessions.put(sessionId, session);
            return session;
        }
    }

    public void deleteSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            sessions.remove(sessionId);
        } else {
            throw new RuntimeMBeanException("No session found with id " + sessionId);
        }
    }

    public class Session {
        private String id;

        public java_21014_SessionManager_A08(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void someSecuritySensitiveOperation() {
            // Simulate a security sensitive operation here
            System.out.println("Running some security sensitive operation on session " + id);
        }
    }
}