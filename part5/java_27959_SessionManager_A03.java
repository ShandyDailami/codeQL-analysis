import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class java_27959_SessionManager_A03 {
    public static void main(String[] args) {
        // Step 1: Create a session factory
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example");

        // Step 2: Use the session factory to create a session
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        // Step 3: Execute a security-sensitive operation
        // In this case, we're creating a new user
        User user = new User("John", "Doe", "john@example.com");
        entityManager.persist(user);

        // Step 4: Commit the transaction
        entityManager.getTransaction().commit();

        // Step 5: Close the session
        entityManager.close();
        entityManagerFactory.close();
    }
}