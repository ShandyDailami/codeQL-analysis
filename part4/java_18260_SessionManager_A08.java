import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class java_18260_SessionManager_A08 {
    private ConcurrentHashMap<String, ReentrantLock> sessionMap;

    public java_18260_SessionManager_A08() {
        sessionMap = new ConcurrentHashMap<>();
    }

    public String createSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session already exists");
        }
        sessionMap.put(sessionId, new ReentrantLock());
        return sessionId;
    }

    public void deleteSession(String sessionId) {
        ReentrantLock lock = sessionMap.get(sessionId);
        if (lock != null) {
            lock.lock();
            try {
                sessionMap.remove(sessionId);
            } finally {
                lock.unlock();
            }
        }
    }

    public boolean validateSession(String sessionId) {
        ReentrantLock lock = sessionMap.get(sessionId);
        return lock != null && lock.tryLock();
    }
}