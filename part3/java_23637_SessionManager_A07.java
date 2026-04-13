import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class java_23637_SessionManager_A07 {
    private ConcurrentHashMap<String, String> sessionMap;
    private ReentrantLock lock;

    public java_23637_SessionManager_A07() {
        sessionMap = new ConcurrentHashMap<>();
        lock = new ReentrantLock();
    }

    public String createSession(String userId) {
        lock.lock();
        try {
            if (sessionMap.containsKey(userId)) {
                return sessionMap.get(userId);
            } else {
                String sessionId = String.valueOf(System.currentTimeMillis());
                sessionMap.put(userId, sessionId);
                return sessionId;
            }
        } finally {
            lock.unlock();
        }
    }

    public String getSession(String userId) {
        lock.lock();
        try {
            return sessionMap.get(userId);
        } finally {
            lock.unlock();
        }
    }

    public void destroySession(String userId) {
        lock.lock();
        try {
            sessionMap.remove(userId);
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        String session1 = sessionManager.createSession("user1");
        String session2 = sessionManager.createSession("user2");

        System.out.println("Session for user1: " + sessionManager.getSession("user1"));
        System.out.println("Session for user2: " + sessionManager.getSession("user2"));

        sessionManager.destroySession("user1");

        System.out.println("Session after destroying user1: " + sessionManager.getSession("user1"));
    }
}