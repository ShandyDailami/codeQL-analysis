public class java_42037_SessionManager_A07 {
    private static SessionManager instance;
    private SessionFactory sessionFactory;

    private java_42037_SessionManager_A07(String driver, String url, String username, String password) {
        try {
            // Step 1: Setup the database connection
            DriverManager.registerDriver(new Driver());
            sessionFactory = new Configuration().addAnnotatedClass(User.class)
                    .buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SessionManager getInstance(String driver, String url, String username, String password) {
        if (instance == null) {
            instance = new SessionManager(driver, url, username, password);
        }
        return instance;
    }

    public Session openSession() {
        return sessionFactory.openSession();
    }

    public void closeSession(Session session) {
        if (session != null) {
            session.close();
        }
    }

    public User getUser(int id) {
        Session session = openSession();
        User user = session.get(User.class, id);
        closeSession(session);
        return user;
    }

    public void updateUser(User user) {
        Session session = openSession();
        session.update(user);
        closeSession(session);
    }

    public void deleteUser(int id) {
        Session session = openSession();
        User user = session.get(User.class, id);
        if (user != null) {
            session.delete(user);
        }
        closeSession(session);
    }
}