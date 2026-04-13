import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.mindrot.jbcrypt.BCrypt;

public class java_16657_SessionManager_A08 {

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

    public static void main(String[] args) {
        // Checking if the password hashes match
        String password = "password";
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        if (BCrypt.checkpw(password, hashedPassword)) {
            System.out.println("Password matches");
        }

        Session session = getSessionFactory().openSession();
        session.beginTransaction();

        // Start the transaction here
        // ...

        session.getTransaction().commit();
        session.close();
    }
}