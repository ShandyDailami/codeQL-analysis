import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class java_25942_SessionManager_A08 {
    private Map<String, String> sessionMap;
    private ReentrantLock lock;

    public java_25942_SessionManager_A08() {
        sessionMap = new HashMap<>();
        lock = new ReentrantLock();
    }

    public void createSession(String sessionId, String userId) {
        lock.lock();
        try {
            sessionMap.put(sessionId, userId);
        } finally {
            lock.unlock();
        }
    }

    public String getUserId(String sessionId) {
        lock.lock();
        try {
            return sessionMap.get(sessionId);
        } finally {
            lock.unlock();
        }
    }

    public void deleteSession(String sessionId) {
        lock.lock();
        try {
            sessionMap.remove(sessionId);
        } finally {
            lock.unlock();
        }
    }
}