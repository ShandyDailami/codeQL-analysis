import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class java_34406_SessionManager_A08 {

    private static EntityManagerFactory emf;
    private static EntityManager em;

    static {
        emf = Persistence.createEntityManagerFactory("my_persistence_unit");
        em = emf.createEntityManager();
    }

    public static void main(String[] args) {

        // Start a new transaction
        em.getTransaction().begin();

        // Create a new user
        User user = new User("John", "Doe", "john@example.com");

        // Add the user to the session
        em.persist(user);

        // Commit the transaction
        em.getTransaction().commit();

        // Close the session
        em.close();
        emf.close();
    }
}