public class java_28670_SessionManager_A03 {
    private SessionFactory sessionFactory;

    public java_28670_SessionManager_A03(String driverName, String dbURL) {
        try {
            // a. Create a SessionFactory using the specified driver name and database URL
            sessionFactory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
        } catch (Exception e) {
            System.out.println("Initial SessionFactory creation failed. " + e.getMessage());
            throw new ExceptionInInitializerError(e);
        }
    }

    public Session getSession(String userName) {
        // b. Get a Session using the user's name
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        return session;
    }

    public void closeSession(Session session) {
        // c. Close the Session using the user's name
        session.getTransaction().commit();
        session.close();
    }
}