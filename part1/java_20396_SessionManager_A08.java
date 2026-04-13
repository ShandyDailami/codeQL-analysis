public class java_20396_SessionManager_A08 {
    private static SessionManager instance = null;
    private SessionFactory sessionFactory = null;

    private java_20396_SessionManager_A08() {
        // Use a standard library or a third-party library for creating a SessionFactory
        // (For example, Hibernate)
        sessionFactory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
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
        if (session != null) {
            session.close();
        }
    }

    public void saveEntity(Object entity) {
        // Use a standard library or a third-party library for saving an entity
        // (For example, Hibernate)
        Session session = getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            closeSession(session);
        }
    }

    public <T> T findEntity(Class<T> clazz, Serializable id) {
        Session session = getSession();
        T entity = null;
        try {
            entity = session.get(clazz, id);
        } finally {
            closeSession(session);
        }
        return entity;
    }

    public <T> void deleteEntity(T entity) {
        Session session = getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            closeSession(session);
        }
    }

    public <T> void updateEntity(T entity) {
        Session session = getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            closeSession(session);
        }
    }
}