public class java_26860_SessionManager_A03 {
    private static SessionManager sessionManager;
    private Session session;

    private java_26860_SessionManager_A03() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            session = SessionFactory.getSessionFactory().openSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    public void commitTransaction() {
        session.getTransaction().commit();
    }

    public void save(Object obj) {
        session.save(obj);
    }

    public void update(Object obj) {
        session.update(obj);
    }

    public void delete(Object obj) {
        session.delete(obj);
    }

    public Object get(Class cls, Serializable id) {
        return session.get(cls, id);
    }
}