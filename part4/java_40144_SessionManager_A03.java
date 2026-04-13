public class java_40144_SessionManager_A03 {
    private static SessionManager instance;
    private Session session;

    private java_40144_SessionManager_A03() {
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

    public void save(Object object) {
        session.save(object);
        session.getTransaction().commit();
    }

    public void update(Object object) {
        session.update(object);
        session.getTransaction().commit();
    }

    public void delete(Object object) {
        session.delete(object);
        session.getTransaction().commit();
    }
}