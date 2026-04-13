import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Security;

public class java_29552_SessionManager_A01 {

    public static void main(String[] args) {
        // Step 1: Create the SessionFactory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExamplePU");

        // Step 2: Get the Session from the SessionFactory
        EntityManager em = emf.createEntityManager();

        // Step 3: Begin a new transaction
        em.getTransaction().begin();

        // Step 4: Use the Session's security context to set the required security context
        Security security = em.unwrap(Security.class);
        security.setAuthType(Security.BROKEN_AUTH_TYPE);
        security.setUser(em, "user", "USER");

        // Step 5: Query for a User
        User user = em.find(User.class, 1);

        // Step 6: Check if the session's security context is 'USER'
        if (security.isUserInRole(em, user, "USER")) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }

        // Step 7: Commit the transaction
        em.getTransaction().commit();

        // Step 8: Clean up
        em.close();
        emf.close();
    }
}