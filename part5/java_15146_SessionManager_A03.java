import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class java_15146_SessionManager_A03 {

    private static EntityManagerFactory entityManagerFactory;

    // Static initializer for entityManagerFactory
    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("example");
    }

    // Get entityManager
    private static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    // Example of a function that opens a session and then closes it.
    public static void main(String[] args) {
        EntityManager entityManager = getEntityManager();

        // Open session
        entityManager.getTransaction().begin();

        // Example operation
        // Assume we have an entity and a query to get that entity
        MyEntity myEntity = entityManager.find(MyEntity.class, 1);

        // Do something with the entity
        // For example, update the name
        myEntity.setName("New Name");

        // Commit the transaction
        entityManager.getTransaction().commit();

        // Close session
        entityManager.close();
    }
}