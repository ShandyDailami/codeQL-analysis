import java.util.HashMap;
import java.util.Map;

public class java_30943_SessionManager_A03 {

    // A map to store sessions. 
    // This is a very basic implementation and a real-world application would use a more robust data structure.
    private Map<String, Session> sessions = new HashMap<>();

    // A session is just a string id.
    private class Session {
        private String id;

        public java_30943_SessionManager_A03(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }
    }

    // Creates a new session.
    public Session createSession() {
        String id = UUID.randomUUID().toString();
        Session session = new Session(id);
        sessions.put(id, session);
        return session;
    }

    // Retrieves a session.
    public Session getSession(String id) {
        return sessions.get(id);
    }

    // Closes a session.
    public void closeSession(String id) {
        sessions.remove(id);
    }
}