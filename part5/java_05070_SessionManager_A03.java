import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_05070_SessionManager_A03 {

    public static void main(String[] args) {
        // Load the configuration
        Configuration configuration = new Configuration();
        configuration.configure();
        
        // Create the SessionFactory
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Create a Session
        Session session = sessionFactory.openSession();

        // Do some security-sensitive operation with the session
        session.doSomethingSensitive();

        // Close the session
        session.close();

        // Close the sessionFactory
        sessionFactory.close();
    }
}