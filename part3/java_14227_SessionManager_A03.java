import java.util.HashMap;
import java.util.UUID;

public class java_14227_SessionManager_A03 {
    private HashMap<UUID, Session> sessions;

    public java_14227_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    public UUID createSession() {
        UUID sessionId = UUID.randomUUID();
        Session session = new Session(sessionId);
        sessions.put(sessionId, session);
        return sessionId;
    }

    public Session getSession(UUID sessionId) {
        return sessions.get(sessionId);
    }

    public void destroySession(UUID sessionId) {
        sessions.remove(sessionId);
    }

    private class Session {
        private UUID id;

        public java_14227_SessionManager_A03(UUID id) {
            this.id = id;
        }

        public UUID getId() {
            return id;
        }

        public void setId(UUID id) {
            this.id = id;
        }
    }
}