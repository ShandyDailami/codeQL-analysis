public class java_12053_SessionManager_A01 {
    private static SessionManager instance;
    private SessionFactory sessionFactory;

    private java_12053_SessionManager_A01() {
        configureSessionFactory();
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    private void configureSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(User.class);
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        sessionFactory = configuration.buildSessionFactory(builder.build());
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
}

public class User {
    private int id;
    private String username;
    private String password;

    // getters and setters
}