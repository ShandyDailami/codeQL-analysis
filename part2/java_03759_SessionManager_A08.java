import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_03759_SessionManager_A08 {

    public static void main(String[] args) {
        // Load the configuration and start the session factory
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Create a new session
        Session session = sessionFactory.openSession();

        // Use the session to perform operations on the database
        session.beginTransaction();

        // Perform a security-sensitive operation
        String sql = "SELECT * FROM Users WHERE username = :username";
        Object[] params = new Object[] { "testUser" };
        session.createSQLQuery(sql).setParameterList(params).addEntity(User.class).list();

        // Commit the transaction
        session.getTransaction().commit();

        // Close the session
        session.close();
    }
}