public class java_16066_SessionManager_A08 {

    private static SessionManager instance;
    private Session session;

    private java_16066_SessionManager_A08() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            session = SessionFactory.openSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public void beginTransaction() {
        session.beginTransaction();
    }

    public void commit() {
        session.getTransaction().commit();
        session.close();
    }

    public void save(Object object) {
        session.save(object);
    }

    public void update(Object object) {
        session.update(object);
    }

    public void delete(Object object) {
        session.delete(object);
    }

    public void integrityFailure() {
        try {
            // This is a security-sensitive operation.
            // In a real application, this operation should not be allowed.
            session.save("This operation is security-sensitive");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}