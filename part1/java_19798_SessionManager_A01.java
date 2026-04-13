import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class java_19798_SessionManager_A01 {
    private Map<String, String> sessionMap = new HashMap<>();
    private ReentrantLock lock = new ReentrantLock();

    public void start() {
        System.out.println("Session manager started.");
    }

    public String createSession(String username) {
        lock.lock();
        try {
            String sessionId = UUID.randomUUID().toString();
            sessionMap.put(sessionId, username);
            System.out.println("Session created: " + sessionId);
            return sessionId;
        } finally {
            lock.unlock();
        }
    }

    public String getUser(String sessionId) {
        lock.lock();
        try {
            return sessionMap.getOrDefault(sessionId, null);
        } finally {
            lock.unlock();
        }
    }

    public void end(String sessionId) {
        lock.lock();
        try {
            sessionMap.remove(sessionId);
            System.out.println("Session ended: " + sessionId);
        } finally {
            lock.unlock();
        }
    }

    public void endAll() {
        lock.lock();
        try {
            sessionMap.clear();
            System.out.println("All sessions ended.");
        } finally {
            lock.unlock();
        }
    }
}