import java.util.HashMap;
import java.util.Map;

public class java_26723_SessionManager_A03 implements SessionManagerInterface {
    private static SessionManager instance = null;
    private Map<String, Session> sessions;

    private java_26723_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    @Override
    public Session getSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return sessions.get(sessionId);
        } else {
            Session session = new Session(sessionId);
            sessions.put(sessionId, session);
            return session;
        }
    }

    @Override
    public void closeSession(String sessionId) {
        sessions.remove(sessionId);
    }

    // Additional methods if needed...
}

interface SessionManagerInterface {
    Session getSession(String sessionId);

    void closeSession(String sessionId);
}