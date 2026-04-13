public class java_14173_SessionManager_A01 {
    private static SessionManager instance;
    private Session session;

    private java_14173_SessionManager_A01() {
        // private constructor to prevent instantiation
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public Session openSession() {
        if (session == null || session.isClosed()) {
            session = Hibernate.openSession();
        }
        return session;
    }

    public void closeSession() {
        if (session != null && !session.isClosed()) {
            session.close();
            session = null;
        }
    }
}