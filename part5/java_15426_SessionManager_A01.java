public class java_15426_SessionManager_A01 {
    private static SessionManager instance;
    private Session session;

    private java_15426_SessionManager_A01() {
        // Create a session
        session = Hibernate.createSessionFactory().openSession();
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public Session getSession() {
        return session;
    }

    public void closeSession() {
        session.close();
    }
}