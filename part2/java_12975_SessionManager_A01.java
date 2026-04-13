import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class java_12975_SessionManager_A01 {
    private static EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("persistenceUnit");
    }

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void main(String[] args) {
        EntityManager em = getEntityManager();

        // Start a transaction
        em.getTransaction().begin();

        // Perform some operations
        // ...

        // Commit the transaction
        em.getTransaction().commit();

        // Close the entity manager
        em.close();
    }
}