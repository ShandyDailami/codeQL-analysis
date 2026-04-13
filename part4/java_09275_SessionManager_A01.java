import java.util.HashMap;
import java.util.UUID;

public class java_09275_SessionManager_A01 {
    private HashMap<UUID, Session> sessions;

    public java_09275_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public Session createSession() {
        Session newSession = new Session();
        sessions.put(newSession.getSessionUUID(), newSession);
        return newSession;
    }

    public Session getSession(UUID sessionUUID) {
        return sessions.get(sessionUUID);
    }

    public void closeSession(UUID sessionUUID) {
        sessions.remove(sessionUUID);
    }

    private class Session {
        private UUID sessionUUID;

        public java_09275_SessionManager_A01() {
            this.sessionUUID = UUID.randomUUID();
        }

        public UUID getSessionUUID() {
            return sessionUUID;
        }
    }
}