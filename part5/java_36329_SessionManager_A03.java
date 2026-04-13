public class java_36329_SessionManager_A03 {
    private static SessionManager instance;
    private Session session;

    private java_36329_SessionManager_A03() {
        // Initialize the Session
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public void beginTransaction() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
    }

    public void commitTransaction() {
        session.getTransaction().commit();
        session.close();
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