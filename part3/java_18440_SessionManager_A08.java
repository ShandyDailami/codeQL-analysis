import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class java_18440_SessionManager_A08 {
    private ConcurrentHashMap<String, String> sessionMap;
    private ReentrantLock lock;

    public java_18440_SessionManager_A08() {
        this.sessionMap = new ConcurrentHashMap<>();
        this.lock = new ReentrantLock();
    }

    public String createSession(String userId) {
        lock.lock();
        try {
            if (sessionMap.containsKey(userId)) {
                throw new SecurityException("Session creation failed. A session already exists for user: " + userId);
            }
            String sessionId = userId + System.currentTimeMillis();
            sessionMap.put(userId, sessionId);
            return sessionId;
        } finally {
            lock.unlock();
        }
    }

    public String getSession(String userId) {
        lock.lock();
        try {
            if (!sessionMap.containsKey(userId)) {
                throw new SecurityException("Session retrieval failed. No session exists for user: " + userId);
            }
            return sessionMap.get(userId);
        } finally {
            lock.unlock();
        }
    }

    public void deleteSession(String userId) {
        lock.lock();
        try {
            if (!sessionMap.containsKey(userId)) {
                throw new SecurityException("Session deletion failed. No session exists for user: " + userId);
            }
            sessionMap.remove(userId);
        } finally {
            lock.unlock();
        }
    }
}