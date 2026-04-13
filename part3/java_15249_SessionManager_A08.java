public class java_15249_SessionManager_A08 {
    private static SessionManager instance;
    private SessionFactory sessionFactory;

    private java_15249_SessionManager_A08() {
        Configuration configuration = new Configuration();
        configuration.configure();

        sessionFactory = configuration.buildSessionFactory(new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties())
                .build());
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public Session getSession(String userName) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // Security-sensitive operations related to A08_IntegrityFailure
        // Example: Check if user exists in a database
        User user = session.get(User.class, userName);
        if (user == null) {
            System.out.println("User not found in database!");
            session.getTransaction().rollback();
            session.close();
            return null;
        }

        session.getTransaction().commit();
        session.close();

        return session;
    }
}