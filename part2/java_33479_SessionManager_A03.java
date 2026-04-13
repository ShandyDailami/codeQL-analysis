import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_33479_SessionManager_A03 {

    private static SessionFactory sessionFactory;

    public static Session openSession() {
        if (sessionFactory == null) {
            try {
                // Load the Hibernate configuration file
                Configuration configuration = new Configuration();
                configuration.configure();

                // Create a SessionFactory from the configuration
                sessionFactory = configuration.buildSessionFactory();
            } catch (Throwable ex) {
                ex.printStackTrace();
                System.out.println("Initial SessionFactory creation failed." + ex);
                throw new ExceptionInInitializerError(ex);
            }
        }
        return sessionFactory.openSession();
    }

    public static void closeSession(Session session) {
        if (session != null) {
            session.close();
        }
    }

    public static void main(String[] args) {
        Session session = openSession();
        // Do some operations here
        closeSession(session);
    }
}