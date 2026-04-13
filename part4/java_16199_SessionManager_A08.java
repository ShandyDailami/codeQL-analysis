import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_16199_SessionManager_A08 {

    private SessionFactory sessionFactory;

    public java_16199_SessionManager_A08() {
        initializeSessionFactory();
    }

    private void initializeSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(registry);
    }

    public Session getSession() {
        Session session = sessionFactory.openSession();

        if (session == null) {
            throw new RuntimeException("Could not open session");
        }

        session.beginTransaction();

        return session;
    }

    public void closeSession(Session session) {
        if (session != null) {
            session.getTransaction().commit();
            session.close();
        }
    }
}