import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class java_05766_SessionManager_A07 {
    public static void main(String[] args) {
        // Create EntityManagerFactory
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPAExample");

        // Create EntityManager
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Open a session
        entityManager.getTransaction().begin();

        // Create a session
        Session session = entityManager.unwrap(Session.class);

        // Perform operations
        User user = session.get(User.class, 1);

        // Commit the transaction
        entityManager.getTransaction().commit();

        // Close the EntityManager
        entityManager.close();

        // Close the EntityManagerFactory
        entityManagerFactory.close();
    }
}