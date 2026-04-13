import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class java_40906_SessionManager_A08 {
    // Use a ThreadLocal for each session
    private static final ThreadLocal<Session> sessionThreadLocal = new ThreadLocal<Session>() {
        @Override
        protected Session initialValue() {
            return new Session();
        }
    };

    // A simple session
    public static class Session {
        private final String id;
        private final AtomicInteger accessCount = new AtomicInteger(0);

        public java_40906_SessionManager_A08() {
            this.id = generateSessionId();
        }

        // This is a very simple session id generation
        private String generateSessionId() {
            return "SESSION_" + System.currentTimeMillis() + "_" + System.nanoTime();
        }

        public void access() {
            accessCount.incrementAndGet();
        }

        public int getAccessCount() {
            return accessCount.get();
        }

        public String getId() {
            return id;
        }
    }

    // This is a simple session manager
    public static class SimpleSessionManager {
        private final ConcurrentHashMap<String, Session> sessionMap = new ConcurrentHashMap<>();

        public Session getSession(boolean createIfNotExist) {
            Session session = sessionThreadLocal.get();
            if (createIfNotExist && session == null) {
                session = new Session();
                sessionMap.put(session.getId(), session);
            }
            return session;
        }
    }

    // This is a simple session manager with a single session per thread
    public static class SingleSessionManager {
        private Session session;

        public Session getSession() {
            if (session == null) {
                session = new Session();
            }
            return session;
        }
    }
}