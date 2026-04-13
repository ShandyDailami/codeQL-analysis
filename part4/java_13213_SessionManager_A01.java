import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class java_13213_SessionManager_A01 {

    private Map<UUID, Session> sessionMap;

    public java_13213_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public Session createSession() {
        Session session = new Session();
        sessionMap.put(session.getId(), session);
        return session;
    }

    public Session getSession(UUID id) {
        return sessionMap.get(id);
    }

    public void deleteSession(UUID id) {
        sessionMap.remove(id);
    }

    public class Session {
        private UUID id;
        private Date creationTime;
        private Date expirationTime;

        public java_13213_SessionManager_A01() {
            this.id = UUID.randomUUID();
            this.creationTime = new Date();
            this.expirationTime = new Date(this.creationTime.getTime() + 1000 * 60 * 60 * 24); // 24 hours
        }

        public UUID getId() {
            return id;
        }

        public Date getCreationTime() {
            return creationTime;
        }

        public Date getExpirationTime() {
            return expirationTime;
        }

        public boolean isActive() {
            return new Date().before(this.expirationTime);
        }
    }
}