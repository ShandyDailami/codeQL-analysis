public class java_27374_SessionManager_A01 {
    private static SessionManager sessionManager;
    private Session session;

    private java_27374_SessionManager_A01() {
        // Create a SessionFactory
        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(User.class).buildSessionFactory();
        session = sessionFactory.openSession();
    }

    public static SessionManager getSessionManager() {
        if (sessionManager == null) {
            sessionManager = new SessionManager();
        }
        return sessionManager;
    }

    public User getUser(int id) {
        return (User) session.get(User.class, id);
    }

    public void updateUser(User user) {
        Transaction tx = session.beginTransaction();
        session.update(user);
        tx.commit();
    }

    public void deleteUser(int id) {
        Transaction tx = session.beginTransaction();
        User user = session.get(User.class, id);
        session.delete(user);
        tx.commit();
    }
}