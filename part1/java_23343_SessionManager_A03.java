import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class java_23343_SessionManager_A03 {

    private final Map<String, Session> sessions;
    private final ReentrantLock lock;

    public java_23343_SessionManager_A03() {
        sessions = new ConcurrentHashMap<>();
        lock = new ReentrantLock();
    }

    public Session getSession(String sessionId) {
        lock.lock();
        try {
            Session session = sessions.get(sessionId);
            if (session == null) {
                session = new Session(sessionId);
                sessions.put(sessionId, session);
            }
            return session;
        } finally {
            lock.unlock();
        }
    }

    public void closeSession(String sessionId) {
        lock.lock();
        try {
            Session session = sessions.get(sessionId);
            if (session != null) {
                sessions.remove(sessionId);
            }
        } finally {
            lock.unlock();
        }
    }

    private class Session {

        private final String id;

        private java_23343_SessionManager_A03(String id) {
            this.id = id;
        }

        // other methods and getters here

    }
}