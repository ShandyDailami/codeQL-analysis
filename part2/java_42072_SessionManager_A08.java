import java.sql.SQLException;

public class java_42072_SessionManager_A08 {

    public static void main(String[] args) {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;

        try {
            // Create session factory
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class).buildSessionFactory();

            // Open session
            session = sessionFactory.openSession();

            // Begin transaction
            transaction = session.beginTransaction();

            // Create a new user
            User user = new User();
            user.setName("John");
            user.setEmail("john@example.com");

            // Save the user
            session.save(user);

            // Commit the transaction
            transaction.commit();

            System.out.println("User saved successfully");
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            // Close session
            session.close();
            sessionFactory.close();
        }
    }
}