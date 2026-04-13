import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_30661_SessionManager_A03 {
    private SessionFactory sessionFactory;

    public java_30661_SessionManager_A03() {
        configureSessionFactory();
    }

    private void configureSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(MyEntity.class); // Assuming you have a MyEntity class
        sessionFactory = configuration.buildSessionFactory();
    }

    public Session openSession() {
        return sessionFactory.openSession();
    }
}