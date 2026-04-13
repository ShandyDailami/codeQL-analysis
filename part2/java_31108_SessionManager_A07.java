public class java_31108_SessionManager_A07 {
    private static ThreadLocal<Session> sessionThreadLocal = new ThreadLocal<Session>();

    public static Session getSession(String connectionName) {
        Session session = sessionThreadLocal.get();

        if (session == null) {
            try {
                session = HibernateUtil.getSessionFactory().openSession(connectionName);
                sessionThreadLocal.set(session);
            } catch (Exception e) {
                e.printStackTrace();
                session = null;
           
                // If it's already opened, just return null.
                // If not, try to open it again.
                if (session == null) {
                    try {
                        session = HibernateUtil.getSessionFactory().openSession(connectionName);
                        sessionThreadLocal.set(session);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        session = null;
                    }
                }
            }
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