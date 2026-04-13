import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_19221_SessionManager_A07 {
    private static SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session openSession() {
        return sessionFactory.openSession();
    }

    public static void main(String[] args) {
        Session session = openSession();

        // Authentication and Authorization
        // Here, let's assume the user's login credentials are correct
        // and the user is authenticated successfully

        // Start of security-sensitive operation
        session.beginTransaction();
        // Let's say we want to get a user's profile information
        User user = session.get(User.class, "001");
        System.out.println("User Profile: " + user.getProfile());
        session.getTransaction().commit();

        // End of security-sensitive operation
        session.close();
    }
}