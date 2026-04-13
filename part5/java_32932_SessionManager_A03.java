import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_32932_SessionManager_A03 {

    private SessionFactory sessionFactory;

    public java_32932_SessionManager_A03() {
        configure();
    }

    private void configure() {
        Configuration configuration = new Configuration();
        configuration.configure();

        sessionFactory = configuration.buildSessionFactory();
    }

    public Session openSession() {
        return sessionFactory.openSession();
    }
}