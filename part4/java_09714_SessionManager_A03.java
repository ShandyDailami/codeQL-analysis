public class java_09714_SessionManager_A03 {
    private static ThreadLocal<Session> sessionThreadLocal = new ThreadLocal<Session>();

    private java_09714_SessionManager_A03() {
        // prevent instantiation
    }

    public static Session getSession() {
        Session session = sessionThreadLocal.get();

        if (session == null) {
            session = HibernateUtil.getSessionFactory().openSession();
            sessionThreadLocal.set(session);
        }

        return session;
    }

    public static void closeSession() {
        Session session = sessionThreadLocal.get();

        if (session != null) {
            session.close();
            sessionThreadLocal.set(null);
        }
    }
}