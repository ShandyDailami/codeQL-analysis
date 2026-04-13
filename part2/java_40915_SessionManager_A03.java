public class java_40915_SessionManager_A03 {
    private SessionFactory sessionFactory;

    public java_40915_SessionManager_A03() {
        // create configuration object and connect to database
        Configuration configuration = new Configuration();
        configuration.configure();

        // create session factory
        sessionFactory = configuration.buildSessionFactory();
    }

    public Session openSession() {
        return sessionFactory.openSession();
    }

    public void closeSession(Session session) {
        session.close();
    }
}