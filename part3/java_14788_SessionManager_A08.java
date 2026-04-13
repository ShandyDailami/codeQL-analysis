public class java_14788_SessionManager_A08 {
    private static SessionManager instance;
    private Session session;

    private java_14788_SessionManager_A08() {
        // Initialize the session
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            session = Session.createSession(new org.hibernate.cfg.Configuration().configure().buildSessionFactory());
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

    public void commitTransaction() {
        session.getTransaction().commit();
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

    public Object get(String id, Class classname) {
        return session.get(classname, id);
    }

    public void closeSession() {
        session.close();
    }
}