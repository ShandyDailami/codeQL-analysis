import java.util.HashMap;
import java.util.Map;

public class java_02212_SessionManager_A01 {
    private Map<String, Session> sessions;

    public java_02212_SessionManager_A01() {
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

    public void closeSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session != null) {
            session.close();
            sessions.remove(sessionId);
        }
    }
}

class Session {
    private String id;
    private boolean isOpen;

    public java_02212_SessionManager_A01(String id) {
        this.id = id;
        this.isOpen = true;
    }

    public void close() {
        isOpen = false;
    }
}