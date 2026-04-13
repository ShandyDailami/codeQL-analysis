public class java_08488_SessionManager_A01 {

    private static SessionManager instance;

    private java_08488_SessionManager_A01() {
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    private Session session;

    public Session openSession() {
        session = openSession();
        return session;
    }

    public void closeSession() {
        session.close();
    }

    public void beginTransaction() {
        session.beginTransaction();
    }

    public void commitTransaction() {
        session.getTransaction().commit();
    }
}