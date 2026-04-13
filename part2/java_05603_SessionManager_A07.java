import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_05603_SessionManager_A07 {

    private static SessionManager sessionManager;
    private SessionFactory sessionFactory;

    private java_05603_SessionManager_A07() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public static SessionManager getInstance() {
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

    public void save(Object object) {
        Session session = openSession();
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
        closeSession(session);
    }

    public void update(Object object) {
        Session session = openSession();
        session.beginTransaction();
        session.update(object);
        session.getTransaction().commit();
        closeSession(session);
    }

    public void delete(Object object) {
        Session session = openSession();
        session.beginTransaction();
        session.delete(object);
        session.getTransaction().commit();
        closeSession(session);
    }
}