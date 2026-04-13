import javax.persistence.*;

public class java_31086_SessionManager_A08 {
    public static void main(String[] args) {
        // Create EntityManagerFactory
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("pu");

        // Create EntityManager
        EntityManager em = factory.createEntityManager();

        try {
            // Begin transaction
            em.getTransaction().begin();

            // Create User
            User user = new User("TestUser", "TestPassword");

            // Add User to session
            em.persist(user);

            // Commit transaction
            em.getTransaction().commit();

            // End transaction
            em.close();
        } finally {
            // Close EntityManagerFactory
            factory.close();
        }
    }
}

@Entity
class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;

    public java_31086_SessionManager_A08(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters and setters are omitted for brevity
}