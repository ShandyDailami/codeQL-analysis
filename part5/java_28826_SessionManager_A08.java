import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_28826_SessionManager_A08 {

    private static SessionFactory sessionFactory;   // session factory (hibernate sessionmaker)

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            } catch (Throwable ex) {
                System.err.println("Initial SessionFactory creation failed." + ex);
                throw new ExceptionInInitializerError(ex);
            }
        }
        return sessionFactory;
    }

    public static void main(String[] args) {

        Session session = getSessionFactory().openSession();

        try {
            session.beginTransaction();

            User user = new User("John", "Doe");
            session.save(user);

            session.getTransaction().commit();
            session.close();

        } finally {
            session.close();
        }
    }
}