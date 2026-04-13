public class java_22479_SessionManager_A01 {
    private static SessionManager instance;
    private Session session;

    private java_22479_SessionManager_A01() {
        // Using the standard library's Hibernate SessionFactory
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
    }

    // Lazy Initialization (Double Checked Locking)
    public static SessionManager getInstance() {
        if (instance == null) {
            synchronized (SessionManager.class) {
                if (instance == null) {
                    instance = new SessionManager();
                }
            }
        }
        return instance;
    }

    public Session getSession() {
        return session;
    }

    public void closeSession() {
        session.close();
    }
}