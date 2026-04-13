public class java_17839_SessionManager_A03 {
    private static SessionManager instance;
    private SessionFactory sessionFactory;

    private java_17839_SessionManager_A03(String driver, String url, String user, String password) {
        try {
            sessionFactory = new Configuration().addAnnotatedClass(User.class).configure().buildSessionFactory();
        } catch (Exception e) {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionManager getInstance(String driver, String url, String user, String password) {
        if (instance == null) {
            instance = new SessionManager(driver, url, user, password);
        }
        return instance;
    }

    public Session openSession() {
        return sessionFactory.openSession();
    }

    public User findUserById(long id) {
        Session session = openSession();
        User user = null;
        try {
            user = session.get(User.class, id);
        } finally {
            session.close();
        }
        return user;
    }
}

public class User {
    private Long id;
    private String name;

    // getters and setters
}