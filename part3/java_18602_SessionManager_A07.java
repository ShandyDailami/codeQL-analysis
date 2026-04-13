import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_18602_SessionManager_A07 {
    private static SessionFactory sessionFactory;

    public static Session getSession() {
        if (sessionFactory == null) {
            try {
                sessionFactory = new Configuration().configure().buildSessionFactory();
            } catch (Throwable ex) {
                ex.printStackTrace();
                System.err.println("Initial SessionFactory creation failed." + ex);
                throw new ExceptionInInitializerError(ex);
            }
        }
        return sessionFactory.openSession();
    }

    public static void main(String[] args) {
        Session session = getSession();
        // Now you can use the session object to perform database operations
        session.beginTransaction();
        // Example of a save operation
        session.save(new User("John"));
        session.getTransaction().commit();
        session.close();
    }
}

class User {
    private String name;

    public java_18602_SessionManager_A07(String name) {
        this.name = name;
    }

    // getters and setters
}