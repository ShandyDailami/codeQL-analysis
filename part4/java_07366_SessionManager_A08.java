import java.util.concurrent.locks.ReentrantLock;
import java.util.HashMap;
import java.util.Map;

public class java_07366_SessionManager_A08 {
    private Map<String, String> sessionMap;
    private ReentrantLock lock;

    public java_07366_SessionManager_A08() {
        sessionMap = new HashMap<>();
        lock = new ReentrantLock();
    }

    public String createSession(String sessionId) {
        lock.lock();
        try {
            sessionMap.put(sessionId, sessionId);
        } finally {
            lock.unlock();
        }
        return sessionId;
    }

    public String getSession(String sessionId) {
        lock.lock();
        try {
            return sessionMap.getOrDefault(sessionId, null);
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