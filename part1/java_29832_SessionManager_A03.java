import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class java_29832_SessionManager_A03 {

    // Create a session factory
    private static EntityManagerFactory entityManagerFactory;

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("persistenceUnit");
    }

    // Create a session
    private static EntityManager entityManager;

    static {
        entityManager = entityManagerFactory.createEntityManager();
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.startSession();
    }

    private void startSession() {
        // Open a session
        entityManager.getTransaction().begin();

        // Perform some operations here...

        // Commit the transaction
        entityManager.getTransaction().commit();

        // Close the session
        entityManager.close();
    }
}