import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class java_30216_SessionManager_A03 {
    private ConcurrentHashMap<String, Session> sessions;
    private ReentrantLock lock;

    public java_30216_SessionManager_A03() {
        sessions = new ConcurrentHashMap<>();
        lock = new ReentrantLock();
    }

    public Session createSession(String sessionId) {
        Session session = new Session(sessionId);
        sessions.put(sessionId, session);
        return session;
    }

    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public void updateSessionContext(String sessionId, SessionContext newContext) {
        lock.lock();
        try {
            Session session = sessions.get(sessionId);
            if (session != null) {
                session.updateContext(newContext);
            }
        } finally {
            lock.unlock();
        }
    }
}