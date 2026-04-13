import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class java_18469_SessionManager_A08 {

    // Define a Map to store sessions
    private Map<String, Session> sessions;

    // Define a ReadWriteLock to prevent concurrent modifications
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public java_18469_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    // Method to get a session
    public Session getSession(String sessionId) {
        lock.readLock().lock();
        try {
            Session session = sessions.get(sessionId);
            if (session == null) {
                session = new Session(sessionId);
                sessions.put(sessionId, session);
            }
            return session;
        } finally {
            lock.readLock().unlock();
        }
    }

    // Method to close a session
    public void closeSession(String sessionId) {
        lock.writeLock().lock();
        try {
            Session session = sessions.get(sessionId);
            if (session != null) {
                sessions.remove(sessionId);
            }
        } finally {
            lock.writeLock().unlock();
        }
    }

    // Session class to store session information
    private class Session {
        private String sessionId;

        public java_18469_SessionManager_A08(String sessionId) {
            this.sessionId = sessionId;
        }

        // Method to get session information
        public String getSessionInfo() {
            // Add security-sensitive operations here
            // For example, check if the sessionId is valid
            // If not, return an error message
            return sessionId;
        }
    }
}