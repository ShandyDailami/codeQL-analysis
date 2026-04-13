import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_08629_SessionManager_A08 {

    private static SessionFactory sessionFactory;  

    public static Session getSession() {
        return sessionFactory.openSession();
    }

    public static void main(String[] args) {
        try {
            // load the configuration
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            
            // build a session factory from the configuration
            sessionFactory = configuration.buildSessionFactory();

            Session session = getSession();
            session.beginTransaction();

            // Perform your operations here

            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }
    }
}