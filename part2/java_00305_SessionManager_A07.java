import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_00305_SessionManager_A07 {
    private static SessionFactory sessionFactory;  

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {  
            try {
                sessionFactory = new Configuration().configure().buildSessionFactory();
            } catch (Throwable ex) {
                System.err.println("Initial SessionFactory creation failed." + ex);
                throw new ExceptionInInitializerError(ex);
            }
        }
        return sessionFactory;
    }

    public static Session getSession() {
        return getSessionFactory().openSession();
    }

    public static void main(String[] args) {
        Session session = getSession();
        session.beginTransaction();
        // perform operations here
        session.getTransaction().commit();
        session.close();
    }
}