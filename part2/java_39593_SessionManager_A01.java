import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_39593_SessionManager_A01 {
    public static void main(String[] args) {
        // create session factory
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        
        SessionFactory factory = configuration.buildSessionFactory();
        
        // create session
        Session session = factory.openSession();
        
        // use session
        session.beginTransaction();
        
        // commit the transaction
        session.getTransaction().commit();
        
        // close session
        session.close();
    }
}