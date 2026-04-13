import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class java_37759_SessionManager_A01 {
    private static final ConcurrentHashMap<String, Session> sessions = new ConcurrentHashMap<>();
    private static final AtomicInteger count = new AtomicInteger();

    public static interface Session {}

    public Session openSession() {
        int id = count.incrementAndGet();
        Session session = new SessionImpl(id);
        sessions.put(String.valueOf(id), session);
        return session;
    }

    public static class SessionImpl implements Session {
        private final int id;

        public java_37759_SessionManager_A01(int id) {
            this.id = id;
        }

        @Override
        public void close() {
            sessions.remove(String.valueOf(id));
        }

        public void brokenMethod() {
            // Simulate a security violation.
            // This method should not be called directly.
            sessions.remove(String.valueOf(id));
        }
    }
}