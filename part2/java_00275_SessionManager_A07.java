import java.util.HashMap;
import java.util.Map;

public class java_00275_SessionManager_A07 {
    private Map<String, Session> sessions;

    public java_00275_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void createSession(Session session) {
        sessions.put(session.getId(), session);
    }

    public void updateSession(Session session) {
        sessions.put(session.getId(), session);
    }

    public void destroySession(String sessionId) {
        sessions.remove(sessionId);
    }

    public static class Session {
        private String id;
        private Object attributes;

        public java_00275_SessionManager_A07(String id) {
            this.id = id;
            this.attributes = new HashMap<>();
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Object getAttributes() {
            return attributes;
        }

        public void setAttributes(Object attributes) {
            this.attributes = attributes;
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        Session session = sessionManager.getSession("session1");
        if (session == null) {
            session = new SessionManager.Session("session1");
            sessionManager.createSession(session);
        }

        session.getAttributes().put("username", "John Doe");

        session = sessionManager.getSession("session1");
        System.out.println("Username: " + session.getAttributes().get("username"));
    }
}