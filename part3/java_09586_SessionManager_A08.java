import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_09586_SessionManager_A08 {
    private static SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() {
        return sessionFactory.openSession();
    }

    public static void main(String[] args) {
        Session session = getSession();

        // Begin transaction
        session.beginTransaction();

        // Example of a security-sensitive operation
        try {
            // Insert a new user
            User user = new User();
            user.setName("John Doe");
            session.save(user);

            // Select user
            User loadedUser = session.get(User.class, user.getId());
            System.out.println("Loaded user: " + loadedUser.getName());
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("An error occurred while inserting or loading a user. Rollback in progress...");
            e.printStackTrace();
        } finally {
            session.getTransaction().commit();
            session.close();
        }
    }
}