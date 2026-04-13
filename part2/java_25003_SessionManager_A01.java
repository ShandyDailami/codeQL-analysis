import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_25003_SessionManager_A01 {

    public static void main(String[] args) {
        Configuration configurer = new Configuration();
        configurer.configure("hibernate.cfg.xml");

        SessionFactory factory = configurer.buildSessionFactory();
        Session session = factory.openSession();

        // Perform operations on the session here.

        session.close();
    }
}