import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_25821_SessionManager_A03 {
    private static SessionFactory sessionFactory;

    private java_25821_SessionManager_A03() {
        // private constructor to prevent instantiation
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                sessionFactory = new Configuration().configure().buildSessionFactory();
            } catch (Throwable ex) {
                System.err.println("Initial SessionFactory creation failed." + ex);
                throw new ExceptionInInitializerError(ex);
            }
        }
        return sessionFactory;
    }

    public Session openSession() {
        return getSessionFactory().openSession();
    }

    public void closeSession(Session session) {
        session.close();
    }

    public void save(Object entity) {
        Session session = openSession();
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
        closeSession(session);
    }

    public <T> T findById(Class<T> clazz, Object id) {
        Session session = openSession();
        T entity = session.get(clazz, id);
        closeSession(session);
        return entity;
    }
}