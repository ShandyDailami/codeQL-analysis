import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Entity;

@Entity
public class java_22505_SessionManager_A01 {

    // Step 1: Define an Entity.
    @Entity
    public static class User {
        @Id
        public Long id;
        public String name;
    }

    public static void main(String[] args) {

        // Step 2: Create a new session factory.
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example");

        // Step 3: Get an entity manager.
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Step 4: Start a transaction.
        entityManager.getTransaction().begin();

        // Step 5: Create a new user.
        User user = new User();
        user.id = 1L;
        user.name = "John Doe";
        entityManager.persist(user);

        // Step 6: Commit the transaction.
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}