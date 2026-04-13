import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_07799_SessionManager_A03 {
    private static SessionManager sessionManager;
    private SessionFactory sessionFactory;

    private java_07799_SessionManager_A03() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public static SessionManager getInstance() {
        if (sessionManager == null) {
            sessionManager = new SessionManager();
        }
        return sessionManager;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }
}

interface UserDao {
    void save(User user);
}

class User {
    private int id;
    private String name;
    private String password;

    // getters and setters
}

class UserDaoImpl implements UserDao {
    public void save(User user) {
        Session session = SessionManager.getInstance().getSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }
}