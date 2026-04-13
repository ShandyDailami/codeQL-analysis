import java.util.HashMap;
import java.util.Map;

public class java_09289_SessionManager_A03 {
    private Map<String, Session> sessions;

    public java_09289_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    public Session getSession(String id) {
        if (sessions.containsKey(id)) {
            return sessions.get(id);
        } else {
            return createSession(id);
        }
    }

    private Session createSession(String id) {
        Session session = new SessionImpl(id);
        sessions.put(id, session);
        return session;
    }

    public void closeSession(String id) {
        sessions.remove(id);
    }

    private class SessionImpl implements Session {
        private String id;

        public java_09289_SessionManager_A03(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public void close() {
            SessionManager.this.closeSession(this.getId());
        }

        public Object setAttribute(String name, Object value) {
            // This is a security sensitive operation related to A03_Injection
            // We simulate it here by returning the parameter value
            return value;
        }
    }

    private interface Session {
        String getId();

        void close();

        Object setAttribute(String name, Object value);
    }
}