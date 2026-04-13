public class java_35175_SessionManager_A08 {

    private static final ThreadLocal<Session> threadLocalSession = new ThreadLocal<Session>();

    public static Session getSession() {
        return threadLocalSession.get();
    }

    public static void setSession(Session session) {
        threadLocalSession.set(session);
    }

    public static void closeSession() {
        Session session = threadLocalSession.get();
        if (session != null) {
            session.close();
            threadLocalSession.remove();
        }
    }
}