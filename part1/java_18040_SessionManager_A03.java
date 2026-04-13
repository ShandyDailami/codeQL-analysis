import java.util.Properties;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_18040_SessionManager_A03 {
    private static final SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();
            sessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session currentSession() {
        return sessionFactory.openSession();
    }

    public static void main(String[] args) {
        Session session = currentSession();
        session.beginTransaction();

        String username = "username";  // This can be an SQL query.
        session.createQuery("FROM User WHERE username = :username")
                .setParameter("username", username)
                .executeUpdate();

        session.getTransaction().commit();
        session.close();
    }
}