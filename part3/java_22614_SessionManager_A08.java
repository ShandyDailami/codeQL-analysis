import java.util.HashMap;
import java.util.Map;

public class java_22614_SessionManager_A08 {
    private Map<String, Session> sessions;

    public java_22614_SessionManager_A08() {
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

    public void closeSession(Session session) {
        sessions.remove(session.getId());
    }

    public static class Session {
        private String id;

        public java_22614_SessionManager_A08(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            // This is a security sensitive operation, let's say we are setting the id
            // Here we are just checking if the id is null or empty and setting it to a random id
            this.id = id != null && !id.isEmpty() ? id : UUID.randomUUID().toString();
        }
    }
}