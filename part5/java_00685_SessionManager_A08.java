public class java_00685_SessionManager_A08 {

    private static SessionManager sessionManager;
    private SessionFactory sessionFactory;

    private java_00685_SessionManager_A08(String driver, String url, String username, String password) {
        sessionFactory = new Configuration().addAnnotatedClass(User.class).configure().buildSessionFactory();
    }

    public static SessionManager getInstance(String driver, String url, String username, String password) {
        if (sessionManager == null) {
            sessionManager = new SessionManager(driver, url, username, password);
        }
        return sessionManager;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }

    public void saveUser(User user) {
        Session session = getSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    public User getUserById(Long id) {
        Session session = getSession();
        User user = session.get(User.class, id);
        session.close();
        return user;
    }

    public void updateUser(User user) {
        Session session = getSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteUser(User user) {
        Session session = getSession();
        session.beginTransaction();
        session.delete(user);
        session.getTransaction().commit();
        session.close();
    }
}