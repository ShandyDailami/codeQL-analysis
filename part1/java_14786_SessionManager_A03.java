import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_14786_SessionManager_A03 {
    private static SessionFactory sessionFactory; // SessionFactory is a tool that allows us to use Hibernate Session

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                configuration.configure("hibernate.cfg.xml");
                sessionFactory = configuration.buildSessionFactory();
            } catch (Throwable ex) {
                System.err.println("Initial SessionFactory creation failed." + ex);
                throw new ExceptionInInitializerError(ex);
            }
        }
        return sessionFactory;
    }

    public static Session openSession() {
        return getSessionFactory().openSession();
    }

    public static void main(String[] args) {
        Session session = openSession();
        try {
            // Use session object to perform operations
            session.beginTransaction();
            // Here you can perform operations like save, update, delete, query etc.
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }
}