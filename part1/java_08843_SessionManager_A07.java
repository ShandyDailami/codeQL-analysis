public class java_08843_SessionManager_A07 {
    private static SessionManager instance;
    private SessionFactory sessionFactory;

    private java_08843_SessionManager_A07() {
        initializeSessionFactory();
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    private void initializeSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure();

        ServiceRegistry registry = new ServiceRegistry(configuration);
        sessionFactory = configuration.buildSessionFactory(registry);
    }

    public Session getSession(String userName) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        return session;
    }

    public void closeSession(Session session) {
        if (session != null) {
            session.getTransaction().commit();
            session.close();
        }
    }

    public void saveUser(User user) {
        Session session = getSession(user.getUsername());
        session.save(user);
        closeSession(session);
    }

    public User getUserByUsername(String username) {
        Session session = getSession(username);
        User user = session.get(User.class, username);
        closeSession(session);
        return user;
    }

    public void deleteUser(User user) {
        Session session = getSession(user.getUsername());
        session.delete(user);
        closeSession(session);
    }

    // Add other session-related methods as needed
}