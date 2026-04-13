import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transaction;
import javax.transaction.Transactional;

@Transactional
public class java_08463_SessionManager_A08 {

    private static final String PERSISTENCE_UNIT_NAME = "examplePU";

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();

        // Start a new transaction
        em.getTransaction().begin();

        // Insert a new user
        User user = new User("admin", "password");
        em.persist(user);

        // Commit the transaction
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    public static class User {
        private String username;
        private String password;

        public java_08463_SessionManager_A08(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}