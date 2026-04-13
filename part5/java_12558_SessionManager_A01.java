import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class java_12558_SessionManager_A01 {
    private EntityManagerFactory emf;

    public java_12558_SessionManager_A01() {
        emf = Persistence.createEntityManagerFactory("examplePU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void closeEntityManager(EntityManager em) {
        em.close();
    }

    public void closeEntityManagerFactory() {
        emf.close();
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        EntityManager em = sessionManager.getEntityManager();

        // Perform operations here...

        sessionManager.closeEntityManager(em);
        sessionManager.closeEntityManagerFactory();
    }
}