import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_32213_SessionManager_A08 {
    // Create the SessionFactory from hibernate.cfg.xml
    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() {
        // If no session is currently open, open one from the pool
        return sessionFactory.openSession();
    }

    // Integrity check method
    public static void integrityCheck() {
        Session session = getSession();
        try {
            // Insert a new user into the database
            session.beginTransaction();
            session.save(new User("Alice"));
            session.getTransaction().commit();

            // Now try to fetch the user Alice from the database
            User user = session.get(User.class, "alice");
            System.out.println(user.getName());

            // Now try to delete the user Alice from the database
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();

            System.out.println("Done");

        } finally {
            session.close();
        }
    }

    public static void main(String[] args) {
        // Perform integrity check
        integrityCheck();
    }
}

// User class
class User {
    private String name;

    public java_32213_SessionManager_A08(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}