import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_40663_SessionManager_A07 {

    private static SessionFactory sessionFactory;

    public static Session getSession() {
        return getSessionFactory().openSession();
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

    public static void main(String[] args) {
        Session session = getSession();
        try {
            session.beginTransaction();

            // Retrieve the user from the database
            User user = session.get(User.class, 123);

            // Perform some security sensitive operation (e.g., auth failure)
            if (user.isAuthFailure()) {
                System.out.println("Auth failure detected, performing operation...");
                // ...
            }

            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }
}