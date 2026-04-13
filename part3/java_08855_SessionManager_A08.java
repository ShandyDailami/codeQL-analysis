import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class java_08855_SessionManager_A08 {

    private static EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("myPU");
    }

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        try {
            // perform operations on the database
            // For example, insert a new user
            User user = new User("John", "Doe", "john@example.com", "password");
            em.persist(user);

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}

class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public java_08855_SessionManager_A08(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    // getters and setters
}