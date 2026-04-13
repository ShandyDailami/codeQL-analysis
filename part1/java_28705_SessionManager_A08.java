import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class java_28705_SessionManager_A08 {

    private final List<Session> sessions;
    private final Lock lock;

    public java_28705_SessionManager_A08() {
        sessions = new ArrayList<>();
        lock = new ReentrantLock();
    }

    public Session createSession() {
        lock.lock();
        try {
            Session session = new Session();
            sessions.add(session);
            return session;
        } finally {
            lock.unlock();
        }
    }

    public void removeSession(Session session) {
        lock.lock();
        try {
            sessions.remove(session);
        } finally {
            lock.unlock();
        }
    }

    public static class Session {
        // Implementation of session class
    }

}