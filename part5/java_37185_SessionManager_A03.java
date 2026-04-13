import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_37185_SessionManager_A03 {

    private static SessionFactory sessionFactory;

    public static Session getSession() {
        if (sessionFactory == null) {
            initSessionFactory();
        }
        return sessionFactory.openSession();
    }

    private static void initSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        // Creating SessionFactory
        sessionFactory = configuration.buildSessionFactory();
    }

    public static void main(String[] args) {
        Session session = getSession();

        // Start a new transaction
        session.beginTransaction();

        // Perform some security-sensitive operation
        session.save(new User(session, "John", "Doe"));

        // Commit the transaction
        session.getTransaction().commit();

        session.close();
    }
}

class User {
    private Long id;
    private String firstName;
    private String lastName;

    public java_37185_SessionManager_A03(Session session, String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        // Create a new user in the database
        session.save(this);
    }
}