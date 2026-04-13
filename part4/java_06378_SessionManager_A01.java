import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_06378_SessionManager_A01 {
    private SessionFactory sessionFactory;

    public java_06378_SessionManager_A01() {
        // Create the SessionFactory from hibernate.cfg.xml
        try {
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public Session openSession() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        return session;
    }

    public void closeSession(Session session) {
        if (session != null && session.getTransaction().isActive()) {
            session.getTransaction().commit();
            session.close();
        }
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();
        Session session = manager.openSession();
        session.save(new User("John"));
        manager.closeSession(session);
    }
}

class User {
    private String name;

    public java_06378_SessionManager_A01(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}