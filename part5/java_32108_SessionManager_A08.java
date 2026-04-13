public class java_32108_SessionManager_A08 {
    private static SessionManager instance;
    private SessionFactory sessionFactory;

    private java_32108_SessionManager_A08() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }

    public void closeSession(Session session) {
        session.close();
    }

    public void saveEntity(Object entity) {
        Session session = getSession();
        try {
            session.save(entity);
            session.beginTransaction();
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void updateEntity(Object entity) {
        Session session = getSession();
        try {
            session.update(entity);
            session.beginTransaction();
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void deleteEntity(Object entity) {
        Session session = getSession();
        try {
            session.delete(entity);
            session.beginTransaction();
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public <T> T getEntityById(Class<T> clazz, Serializable id) {
        Session session = getSession();
        T entity = null;
        try {
            entity = session.get(clazz, id);
        } finally {
            session.close();
        }
        return entity;
    }
}