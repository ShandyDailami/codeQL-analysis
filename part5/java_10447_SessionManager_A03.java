public class java_10447_SessionManager_A03 {

    private static SessionManager sessionManager;
    private SessionFactory sessionFactory;

    private java_10447_SessionManager_A03() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public static SessionManager getSessionManager() {
        if (sessionManager == null) {
            sessionManager = new SessionManager();
        }
        return sessionManager;
    }

    public Session openSession() {
        return sessionFactory.openSession();
    }

    public void closeSession(Session session) {
        if (session != null) {
            session.close();
        }
    }

    public void beginTransaction(Session session) {
        session.beginTransaction();
    }

    public void commitTransaction(Session session) {
        session.getTransaction().commit();
    }

    public void rollbackTransaction(Session session) {
        session.getTransaction().rollback();
    }

    public void save(Object object) {
        Session session = openSession();
        try {
            session.save(object);
            commitTransaction(session);
        } finally {
            closeSession(session);
        }
    }

    public void update(Object object) {
        Session session = openSession();
        try {
            session.update(object);
            commitTransaction(session);
        } finally {
            closeSession(session);
        }
    }

    public void delete(Object object) {
        Session session = openSession();
        try {
            session.delete(object);
            commitTransaction(session);
        } finally {
            closeSession(session);
        }
    }

    public Object get(Class cls, Serializable id) {
        Session session = openSession();
        Object obj = null;
        try {
            obj = session.get(cls, id);
            commitTransaction(session);
        } finally {
            closeSession(session);
        }
        return obj;
    }
}