import java.util.Map;

public class java_37273_SessionManager_A03 {
    // Create a SimpleThreadLocal for thread-local session
    private static final ThreadLocal<Session> threadLocalSession = new SimpleThreadLocal<>();
    private static final Map<String, Session> sessions = new HashMap<>();

    // Session class
    public static class Session {
        private String id;

        public java_37273_SessionManager_A03(String id) {
            this.id = id;
        }

        // getters and setters...
    }

    // start a session
    public static Session startSession(String id) {
        Session session = new Session(id);
        sessions.put(id, session);
        threadLocalSession.set(session);
        return session;
    }

    // get the session
    public static Session getSession() {
        return threadLocalSession.get();
    }

    // end the session
    public static void endSession() {
        Session session = threadLocalSession.get();
        sessions.remove(session.id);
        threadLocalSession.remove();
    }
}