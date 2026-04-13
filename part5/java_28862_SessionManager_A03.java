import java.util.HashMap;
import java.util.Map;

public class java_28862_SessionManager_A03 {

    // Injecting SessionFactory via constructor.
    private SessionFactory sessionFactory;

    public java_28862_SessionManager_A03(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Map<Long, Session> sessionMap = new HashMap<>();

    // Open a Session
    public Session openSession() {
        Session session = sessionMap.get(ThreadId.get());

        if (session == null) {
            session = sessionFactory.openSession();
            sessionMap.put(ThreadId.get(), session);
        }

        return session;
    }

    // Close the Session
    public void closeSession(Session session) {
        sessionMap.remove(ThreadId.get());
        session.close();
    }

    public static class ThreadId {
        private static ThreadLocal<Long> threadId = new ThreadLocal<Long>() {
            @Override
            protected Long initialValue() {
                return System.currentTimeMillis();
            }
        };

        public static Long get() {
            return threadId.get();
        }
    }
}