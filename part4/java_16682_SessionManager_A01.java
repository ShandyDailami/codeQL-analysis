import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_16682_SessionManager_A01 {

    private static SessionFactory sessionFactory;

    public static Session getSession() {
        if (sessionFactory == null) {
            initializeSessionFactory();
        }
        return sessionFactory.openSession();
    }

    private static void initializeSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();
    }

    public static void main(String[] args) {
        Session session = getSession();
        // Start your operations here
        session.beginTransaction();
        // Example of a query
        //session.createQuery("from Employees").list().forEach(System.out::println);
        session.getTransaction().commit();
        session.close();
    }
}