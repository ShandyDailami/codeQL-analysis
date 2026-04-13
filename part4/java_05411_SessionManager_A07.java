public class java_05411_SessionManager_A07 {
    private static SessionManager instance;
    private SessionFactory sessionFactory;

    private java_05411_SessionManager_A07() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }

    public void closeSession(Session session) {
        if (session != null) {
            session.close();
        }
    }

    public void closeSessionFactory() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

    public void beginTransaction(Session session) {
        if (session != null) {
            session.beginTransaction();
        }
    }

    public void commitTransaction(Session session) {
        if (session != null) {
            session.getTransaction().commit();
        }
    }

    public void rollbackTransaction(Session session) {
        if (session != null) {
            session.getTransaction().rollback();
        }
    }

    public void closeSessionAndFactory() {
        closeSessionFactory();
        closeSession(null);
    }
}