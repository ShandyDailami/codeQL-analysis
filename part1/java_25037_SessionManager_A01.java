import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_25037_SessionManager_A01 {

    private static SessionFactory sessionFactory;

    // Create the sessionFactory from hibernate.cfg.xml
    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() {
        return sessionFactory.openSession();
    }

    public static void main(String[] args) {
        Session session = getSession();
        // start writing your code here to interact with the database
        session.beginTransaction();
        //...
        session.getTransaction().commit();
        session.close();
    }
}