import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class java_06349_SessionManager_A03 {
    private static final String PERSISTENCE_UNIT_NAME = "myPersistenceUnit";

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager entityManager = factory.createEntityManager();

        // Open a session
        entityManager.getTransaction().begin();

        // Perform operations here...

        // Close the session
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}