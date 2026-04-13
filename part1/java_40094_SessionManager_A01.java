import java.util.HashMap;
import java.util.Map;

public class java_40094_SessionManager_A01 {
    private Map<String, Session> sessions;

    public java_40094_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void setSession(String sessionId, Session session) {
        sessions.put(sessionId, session);
    }

    public void closeSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session != null) {
            session.close();
            sessions.remove(sessionId);
        }
    }

    public void openSession(String sessionId) {
        Session session = new Session();
        setSession(sessionId, session);
    }
}

class Session {
    private boolean isActive;

    public void close() {
        isActive = false;
        System.out.println("Session closed.");
    }

    public void open() {
        isActive = true;
        System.out.println("Session opened.");
    }

    public boolean isActive() {
        return isActive;
    }
}