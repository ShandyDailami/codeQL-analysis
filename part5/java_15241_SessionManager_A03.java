import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class java_15241_SessionManager_A03 {

    // Step 1: Define your security credentials
    private static final String PERSISTENCE_UNIT_NAME = "PersistenceUnit";
    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    // Step 2: Create an EntityManagerFactory
    private EntityManagerFactory emf;

    public java_15241_SessionManager_A03() {
        emf = Persistence.createPersistenceUnit(PERSISTENCE_UNIT_NAME, USERNAME, PASSWORD);
    }

    // Step 3: Create an EntityManager
    public EntityManager createEntityManager() {
        return emf.createEntityManager();
    }

    // Step 4: Close the EntityManager
    public void closeEntityManager(EntityManager em) {
        if (em != null && em.isOpen()) {
            em.close();
        }
    }

    public static void main(String[] args) {
        SecureSessionManager sessionManager = new SecureSessionManager();
        EntityManager em = sessionManager.createEntityManager();

        // Step 5: Use the EntityManager for security-sensitive operations
        // ...

        sessionManager.closeEntityManager(em);
    }
}