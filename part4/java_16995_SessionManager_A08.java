import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_16995_SessionManager_A08 {
    private static SessionFactory sessionFactory;

    // This method will be invoked before your main() method
    public static void init() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        sessionFactory = configuration.buildSessionFactory();
    }

    public static Session openSession() {
        return sessionFactory.openSession();
    }

    public static void closeSession(Session session) {
        if (session != null) {
            session.close();
        }
    }

    public static void main(String[] args) {
        init();

        Session session = openSession();

        // Perform some operations on the session here.
        // For example, we can save a user.
        session.beginTransaction();

        // Here, you would perform your operations and save the user.
        // User user = new User("John", "Doe");
        // session.save(user);

        session.getTransaction().commit();
        closeSession(session);
    }
}