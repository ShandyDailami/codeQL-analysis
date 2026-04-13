import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_19748_SessionManager_A08 {
    public static void main(String[] args) {
        // Configure Hibernate
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Start a new session
        Session session = sessionFactory.openSession();

        // Verify session integrity
        try {
            session.getTransaction().begin();
            session.getTransaction().commit();
            System.out.println("Session integrity: " + (session.getTransaction().wasCommitted() ? "Committed" : "Not committed"));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
        } finally {
            session.close();
        }
    }
}