public class java_27486_SessionManager_A08 {

    private static SessionManager sessionManager = null;
    private static SessionFactory sessionFactory = null;

    private java_27486_SessionManager_A08() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public static SessionManager getSessionManager() {
        if (sessionManager == null) {
            sessionManager = new SessionManager();
        }
        return sessionManager;
    }

    public Session openSession() {
        return sessionFactory.openSession();
    }

    public void closeSession(Session session) {
        if (session != null) {
            session.close();
        }
    }

    public void beginTransaction(Session session) {
        session.beginTransaction();
    }

    public void commitTransaction(Session session) {
        session.getTransaction().commit();
    }

    public void rollbackTransaction(Session session) {
        session.getTransaction().rollback();
    }
}