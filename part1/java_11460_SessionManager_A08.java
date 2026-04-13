import java.util.HashMap;
import java.util.UUID;

public class java_11460_SessionManager_A08 {
    private HashMap<UUID, Session> sessions;

    public java_11460_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public Session createSession() {
        Session session = new Session();
        sessions.put(session.getId(), session);
        return session;
    }

    public Session getSession(UUID id) {
        return sessions.get(id);
    }

    public void invalidateSession(UUID id) {
        sessions.remove(id);
    }

    public class Session {
        private UUID id;

        public java_11460_SessionManager_A08() {
            this.id = UUID.randomUUID();
        }

        public UUID getId() {
            return id;
        }
    }
}