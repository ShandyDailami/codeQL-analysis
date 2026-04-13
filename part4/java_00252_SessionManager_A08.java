import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_00252_SessionManager_A08 {

    // Create the SessionFactory from hibernate.cfg.xml
    private static final SessionFactory sessionFactory;
    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed" + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws Exception {
        return sessionFactory.openSession();
    }

    public static void main(String[] args) {
        Session session = null;
        try {
            session = getSession();
            // Starts the transaction
            session.beginTransaction();

            // Retrieve an object by id from the database
            // Assuming we have a Person object with an id of 1
            Object person = session.get(Person.class, 1);
            System.out.println("Person found: " + person);

            // Commits the transaction
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}