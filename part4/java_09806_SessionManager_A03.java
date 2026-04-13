import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_09806_SessionManager_A03 {

    private static SessionFactory sessionFactory;   // SessionFactory is a tool that allows the program to use Hibernate and has control over the lifecycle of the session.

    // Static initializer for the SessionFactory
    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    // Get the current session
    public static Session getSession() throws Exception {
        Session session = null;
        try {
            session = sessionFactory.openSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return session;
    }

    public static void main(String[] args) throws Exception {
        Session session = getSession();
        if (session != null) {
            System.out.println("Session opened");
            // perform operations here
            session.close();
        }
    }
}