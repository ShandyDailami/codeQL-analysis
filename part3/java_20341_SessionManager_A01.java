public class java_20341_SessionManager_A01 {
    private static SessionManager instance;
    private Session session;

    private java_20341_SessionManager_A01() {
        session = null;
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public Session getSession() {
        if (session == null || session.getTransaction().isActive()) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        return session;
    }

    public void closeSession() {
        if (session != null && session.getTransaction().isActive()) {
            session.getTransaction().commit();
            session.close();
        }
    }
}