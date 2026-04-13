public class java_27774_SessionManager_A08 {
    private static SessionManager sessionManager;
    private Session session;

    private java_27774_SessionManager_A08() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public static SessionManager getSessionManager() {
        if (sessionManager == null) {
            sessionManager = new SessionManager();
        }
        return sessionManager;
    }

    public void beginTransaction() {
        session.beginTransaction();
    }

    public void commit() {
        session.getTransaction().commit();
        session.close();
    }

    public void save(Object obj) {
        session.save(obj);
        session.getTransaction().commit();
    }

    public void update(Object obj) {
        session.update(obj);
        session.getTransaction().commit();
    }

    public void delete(Object obj) {
        session.delete(obj);
        session.getTransaction().commit();
    }

    public static void main(String[] args) {
        SessionManager sm = SessionManager.getSessionManager();
        sm.beginTransaction();
        // sm.save(new User("Admin", "User")); // Commenting this line will fail the integrity test.
        sm.commit();
    }
}