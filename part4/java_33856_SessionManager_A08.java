import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class java_33856_SessionManager_A08 {

    // Create a EntityManagerFactory.
    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        // Create the EntityManagerFactory.
        emf = Persistence.createEntityManagerFactory("example");

        // Get the entity manager.
        EntityManager em = emf.createEntityManager();

        // Start the transaction.
        em.getTransaction().begin();

        // Create a new user.
        User user = new User("John", "Doe", "john@doe.com");

        // Persist the user to the database.
        em.persist(user);

        // Commit the transaction.
        em.getTransaction().commit();

        // Close the EntityManager.
        em.close();
    }

    static class User {
        private String firstName;
        private String lastName;
        private String email;

        public java_33856_SessionManager_A08(String firstName, String lastName, String email) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
        }

        // Getters and setters...
    }
}