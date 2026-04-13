import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class java_30977_SessionManager_A03 {

    public static void main(String[] args) {
        // Step 1: Create EntityManagerFactory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("userPersistenceUnit");

        // Step 2: Create EntityManager
        EntityManager em = emf.createEntityManager();

        // Step 3: Create a session
        em.getTransaction().begin();

        // Step 4: Perform a CriteriaQuery
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> root = cq.from(User.class);
        cq.select(root);

        // Step 5: Execute the query and get the result
        User user = em.createQuery(cq).getSingleResult();

        // Step 6: Complete the transaction
        em.getTransaction().commit();
        em.close();
        emf.close();

        // The User object is safe to use because it does not contain any sensitive information
        System.out.println(user.toString());
    }
}

class User {
    private String username;
    private String password;

    // getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [username=" + username + ", password=" + password + "]";
    }
}