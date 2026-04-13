import java.security.Key;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class java_18293_SessionManager_A01 {
    private static final int SESSION_LIMIT = 100;
    private static final long VALIDITY_TIME = 600000; // 100 minutes

    private Map<String, Session> sessions;
    private Map<String, Key> keys;
    private Map<String, Long> lastAccessed;
    private ReentrantLock lock;

    public java_18293_SessionManager_A01() {
        sessions = new HashMap<>();
        keys = new HashMap<>();
        lastAccessed = new HashMap<>();
        lock = new ReentrantLock();
    }

    public String createSession(Key key) {
        lock.lock();
        try {
            if (sessions.size() == SESSION_LIMIT) {
                return "Error: Session limit reached";
            }

            String sessionId = generateSessionId();
            sessions.put(sessionId, new Session(key, VALIDITY_TIME));
            keys.put(sessionId, key);
            lastAccessed.put(sessionId, System.currentTimeMillis());

            return sessionId;
        } finally {
            lock.unlock();
        }
    }

    public boolean validateSession(String sessionId, Key key) {
        lock.lock();
        try {
            Session session = sessions.get(sessionId);
            if (session == null || !session.isValid(key)) {
                return false;
            }

            lastAccessed.put(sessionId, System.currentTimeMillis());

            return true;
        } finally {
            lock.unlock();
        }
    }

    private String generateSessionId() {
        return Long.toHexString(System.nanoTime() & 0xffffffffffffffffL);
    }

    private class Session {
        private Key key;
        private long expirationTime;

        public java_18293_SessionManager_A01(Key key, long expirationTime) {
            this.key = key;
            this.expirationTime = System.currentTimeMillis() + expirationTime;
        }

        public boolean isValid(Key key) {
            return this.key.equals(key) && System.currentTimeMillis() < expirationTime;
        }
    }
}