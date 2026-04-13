import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpSession;

public class java_01743_SessionManager_A03 {

    public static void main(String[] args) {
        // Step 1: Get the EntityManagerFactory
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("myPU");

        // Step 2: Get an entity manager
        EntityManager entityManager = factory.createEntityManager();

        // Step 3: Create and start a session
        entityManager.getTransaction().begin();

        // Step 4: Create a new User entity
        User user = new User("John Doe", "john@example.com");

        // Step 5: Persist the user in the database
        entityManager.persist(user);

        // Step 6: Commit the transaction
        entityManager.getTransaction().commit();

        // Step 7: Create a new session
        HttpSession session = entityManager.unwrap(HttpSession.class);

        // Step 8: Store a message in the session
        session.setAttribute("message", "Hello, User!");
    }
}

class User {
    private String name;
    private String email;

    public java_01743_SessionManager_A03(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters and setters
    // ...
}