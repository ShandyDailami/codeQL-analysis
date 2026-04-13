import javax.persistence.*;

public class java_38570_SessionManager_A01 {

    private EntityManager entityManager;

    public java_38570_SessionManager_A01() {
        // Create a new EntityManagerFactory
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-demo");

        // Create a new EntityManager
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void startSession() {
        try {
            // Start a new transaction
            entityManager.getTransaction().begin();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void endSession() {
        try {
            // Commit the transaction
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the EntityManager
            entityManager.close();
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.startSession();

        // Perform some operations here...

        sessionManager.endSession();
    }
}