import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class java_30147_SessionManager_A03 {
    private static EntityManagerFactory emf;
    private static EntityManager em;

    public static void main(String[] args) {
        // Create the entity manager factory
        emf = Persistence.createEntityManagerFactory("example");
        em = emf.createEntityManager();

        // Begin the transaction
        em.getTransaction().begin();

        // Perform a security-sensitive operation
        SecurityOperation(em);

        // Commit the transaction
        em.getTransaction().commit();

        // Close the entity manager
        em.close();
        emf.close();
    }

    private static void SecurityOperation(EntityManager em) {
        // Create a new user and save it to the database
        User user = new User();
        user.setName("John Doe");
        user.setEmail("john@example.com");
        em.persist(user);

        // Retrieve all users from the database
        user = em.find(User.class, user.getId());
        System.out.println("User name: " + user.getName());
        System.out.println("User email: " + user.getEmail());

        // Update the user email
        user.setEmail("john.new@example.com");
        em.merge(user);

        // Delete the user
        em.remove(user);
    }
}