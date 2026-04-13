public class java_18546_SessionManager_A03 {
    private SessionFactory sessionFactory;

    public java_18546_SessionManager_A03() {
        // Initialize session factory
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class).buildSessionFactory();
    }

    public Session openSession() {
        // Open a new session
        return sessionFactory.openSession();
    }

    public void closeSession(Session session) {
        // Close the session and release it back to the pool
        session.close();
    }

    public void saveUser(User user) {
        Session session = openSession();
        Transaction tx = session.beginTransaction();
        session.save(user);
        tx.commit();
        closeSession(session);
    }

    // Other methods to perform operations on User entities
}