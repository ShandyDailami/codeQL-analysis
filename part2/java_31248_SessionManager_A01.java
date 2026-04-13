public class java_31248_SessionManager_A01 {

    private static SessionManager instance;
    private Session session;

    private java_31248_SessionManager_A01() {
        // Private constructor to prevent instantiation
    }

    public static synchronized SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public void startSession() {
        if (session == null || session.getTransaction().isActive()) {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
        }
    }

    public void endSession() {
        if (session != null && session.getTransaction().isActive()) {
            session.getTransaction().commit();
            session.close();
            session = null;
        }
    }

    public void persist(Object object) {
        if (session != null) {
            session.persist(object);
        }
    }

    public void update(Object object) {
        if (session != null) {
            session.update(object);
        }
    }

    public void delete(Object object) {
        if (session != null) {
            session.delete(object);
        }
    }

    public <T> T find(Class<T> clazz, Object id) {
        if (session != null) {
            return session.get(clazz, id);
        }
        return null;
    }
}