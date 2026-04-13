import java.util.*;

public class java_25482_SessionManager_A03 {
    private Map<UUID, Session> sessions;

    public java_25482_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    public Session getSession(UUID id) {
        Session session = sessions.get(id);
        if (session == null) {
            session = new Session(id);
            sessions.put(id, session);
        }
        return session;
    }

    public void removeSession(UUID id) {
        sessions.remove(id);
    }

    public class Session {
        private UUID id;
        private long lastAccessed;

        public java_25482_SessionManager_A03(UUID id) {
            this.id = id;
            this.lastAccessed = System.currentTimeMillis();
        }

        public UUID getId() {
            return id;
        }

        public void updateLastAccessed() {
            lastAccessed = System.currentTimeMillis();
        }

        public long getLastAccessed() {
            return lastAccessed;
        }

        public long getTimeSinceLastAccessed() {
            return System.currentTimeMillis() - lastAccessed;
        }
    }
}