// Import required Java libraries
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class java_15312_SessionManager_A07 {
    // Main method
    public static void main(String[] args) {
        // Step 1: Create the session factory
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExamplePersistenceUnit");

        // Step 2: Create the session
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        // Step 3: Execute a security-sensitive operation
        // Assume that the operation is to get a user
        User user = entityManager.find(User.class, 1); // Assuming we have a User entity and a method to get a user by id

        // Step 4: Commit the transaction
        entityManager.getTransaction().commit();

        // Step 5: Close the session
        entityManager.close();
        entityManagerFactory.close();
    }
}