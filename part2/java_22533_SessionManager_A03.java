import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class java_22533_SessionManager_A03 {

    private static SessionFactory sessionFactory;

    static {
        try {
            // Load the configuration file and initialize a SessionFactory
            Configuration configuration = new Configuration();
            configuration.configure(); // configure it, add an xml or yaml file

            sessionFactory = configuration.buildSessionFactory();
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
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            // perform your operations here

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}