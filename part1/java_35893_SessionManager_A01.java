import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
public class java_35893_SessionManager_A01 {
    @Id
    @Column(name="id")
    private int id;
    
    @Column(name="username")
    private String username;
    
    // Constructors, getters and setters are not shown for brevity
}

public class Main {
    private static final String PERSISTENCE_UNIT_NAME = "examplePU";
    
    public static void main(String[] args) {
        // Step 1: Create the entity manager factory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        
        // Step 2: Retrieve a session
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        // Step 3: Create an instance of User and save it
        User user = new User();
        user.setId(1);
        user.setUsername("testuser");
        em.persist(user);
        
        // Step 4: End the transaction
        em.getTransaction().commit();
        em.close();
        
        // Step 5: Cleanup: Close the entity manager factory
        emf.close();
    }
}