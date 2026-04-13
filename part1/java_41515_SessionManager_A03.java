public class java_41515_SessionManager_A03 {
    private static SessionManager sessionManager;
    private SessionFactory sessionFactory;

    private java_41515_SessionManager_A03() {
        // Using standard Java libraries
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();
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

    public void save(Object object) {
        Session session = openSession();
        Transaction transaction = session.beginTransaction();
        session.save(object);
        transaction.commit();
        closeSession(session);
    }

    public void update(Object object) {
        Session session = openSession();
        Transaction transaction = session.beginTransaction();
        session.update(object);
        transaction.commit();
        closeSession(session);
    }

    public void delete(Object object) {
        Session session = openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(object);
        transaction.commit();
        closeSession(session);
    }
}