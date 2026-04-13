import javax.sql.DataSource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_11413_SessionManager_A01 {

    private SessionFactory sessionFactory;   // SessionFactory is the object that provides the thread-safe Session object.

    public java_11413_SessionManager_A01() {
        // Create the SessionFactory from hibernate.cfg.xml
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();
    }

    // Method to open a Session
    public Session openSession() {
        return sessionFactory.openSession();
    }

    // Method to close the session
    public void closeSession(Session session) {
        if (session != null) {
            session.close();
        }
    }
}