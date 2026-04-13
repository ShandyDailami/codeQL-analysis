import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class java_37595_SessionManager_A03 {
    private final UUID id;
    private Object data;

    public java_37595_SessionManager_A03(Object data) {
        this.id = UUID.randomUUID();
        this.data = data;
    }

    public UUID getId() {
        return id;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

public class SessionManager {
    private Map<UUID, Session> sessions;

    public java_37595_SessionManager_A03() {
        this.sessions = new HashMap<>();
    }

    public Session createSession(Object data) {
        Session session = new Session(data);
        this.sessions.put(session.getId(), session);
        return session;
    }

    public Object getData(UUID sessionId) {
        Session session = this.sessions.get(sessionId);
        return session != null ? session.getData() : null;
    }

    public void updateData(UUID sessionId, Object newData) {
        Session session = this.sessions.get(sessionId);
        if (session != null) {
            session.setData(newData);
        }
    }

    public void destroySession(UUID sessionId) {
        this.sessions.remove(sessionId);
    }
}