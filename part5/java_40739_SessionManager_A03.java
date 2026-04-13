import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class java_40739_SessionManager_A03 {
    private EntityManagerFactory emf;

    public java_40739_SessionManager_A03() {
        emf = Persistence.createEntityManagerFactory("example");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void closeEntityManager(EntityManager em) {
        em.close();
    }

    public void openTransaction(EntityManager em) {
        em.getTransaction().begin();
    }

    public void commitTransaction(EntityManager em) {
        em.getTransaction().commit();
    }

    public void rollbackTransaction(EntityManager em) {
        em.getTransaction().rollback();
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        EntityManager em = sessionManager.getEntityManager();

        // Open a transaction
        sessionManager.openTransaction(em);

        // Perform some operations
        // ...

        // Commit the transaction
        sessionManager.commitTransaction(em);

        // Close the entity manager
        sessionManager.closeEntityManager(em);
    }
}