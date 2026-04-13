import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class java_24425_SessionManager_A08 {
    private Map<String, ReentrantLock> sessions;

    public java_24425_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public void openSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            throw new RuntimeException("Session with id " + sessionId + " already exists");
        }
        ReentrantLock lock = new ReentrantLock();
        sessions.put(sessionId, lock);
    }

    public void closeSession(String sessionId) {
        ReentrantLock lock = sessions.get(sessionId);
        if (lock != null) {
            lock.lock();
            try {
                if (lock.tryLock()) {
                    sessions.remove(sessionId);
                } else {
                    throw new RuntimeException("Session with id " + sessionId + " could not be closed");
                }
            } finally {
                lock.unlock();
            }
        } else {
            throw new RuntimeException("Session with id " + sessionId + " does not exist");
        }
    }
}