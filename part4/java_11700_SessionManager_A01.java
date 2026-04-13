import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_11700_SessionManager_A01 {

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

    public static Session getSession() {
        return getSessionFactory().openSession();
    }

    public static void main(String[] args) {
        Session session = getSession();
        try {
            // Example of a security-sensitive operation
            session.beginTransaction();
            // Here, you could perform operations that violate access control
            session.save(new User("admin", "password"));
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

    static class User {
        private String name;
        private String password;

        public java_11700_SessionManager_A01(String name, String password) {
            this.name = name;
            this.password = password;
        }

        // Getters and setters...
    }
}