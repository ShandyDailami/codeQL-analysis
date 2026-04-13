import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class java_07566_SessionManager_A08 {
    @Id
    private String username;
    private String password;

    // Constructors, getters and setters
    // ...
}

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SessionManager {

    private static final String PERSISTENCE_UNIT_NAME = "myPU";

    private EntityManagerFactory emf;

    public java_07566_SessionManager_A08() {
        emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    public void storeUserPassword(String username, String password) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        em.persist(user);

        em.getTransaction().commit();
        em.close();
    }

    public boolean authenticateUser(String username, String password) {
        EntityManager em = emf.createEntityManager();
        User user = em.find(User.class, username);

        if (user == null) {
            return false;
        }

        // Assuming passwords are stored as plain text, you might want to hash the provided password instead.
        return user.getPassword().equals(password);
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();
        sm.storeUserPassword("john", "password");

        boolean success = sm.authenticateUser("john", "password");
        System.out.println("Authenticated: " + success);

        sm.emf.close();
    }
}