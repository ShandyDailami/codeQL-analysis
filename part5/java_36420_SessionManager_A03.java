import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_36420_SessionManager_A03 {

    private static SessionFactory sessionFactory;

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

    public static Session openSession() {
        return getSessionFactory().openSession();
    }

    public static void main(String[] args) {
        Session session = openSession();
        try {
            session.beginTransaction();
            // Example: insert a new user
            session.save(new User("John", "Doe"));
            session.getTransaction().commit();
        } catch (Exception ex) {
            System.err.println("Error in transaction: " + ex);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public static class User {
        private String firstName;
        private String lastName;

        public java_36420_SessionManager_A03(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        // getters and setters
    }
}