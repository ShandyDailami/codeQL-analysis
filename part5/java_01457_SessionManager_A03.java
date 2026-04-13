import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_01457_SessionManager_A03 {
    private static SessionFactory sessionFactory;

    static {
        try {
            // Load the configuration file
            Configuration configuration = new Configuration();
            configuration.configure();

            // Create the SessionFactory
            sessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws Exception {
        return sessionFactory.openSession();
    }

    public static void main(String[] args) {
        try (Session session = getSession()) {
            // TODO: add your session operations here
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}