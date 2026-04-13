import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public class java_03315_SessionManager_A03 {

    private EntityManagerFactory emf;

    // Singleton pattern to ensure only one instance of the SessionManager
    private static SessionManager instance;

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    private java_03315_SessionManager_A03() {
        emf = Persistence.createEntityManagerFactory("examplePU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void closeEntityManager() {
        emf.close();
    }

    public static void main(String[] args) {
        SessionManager sm = SessionManager.getInstance();
        sm.executeSession(em -> {
            em.getTransaction().begin();
            // perform operations here...
            em.getTransaction().commit();
        });
        sm.closeEntityManager();
    }

    public void executeSession(SessionAction action) {
        EntityManager em = getEntityManager();
        try {
            action.execute(em);
        } finally {
            closeEntityManager();
        }
    }

    @FunctionalInterface
    public interface SessionAction {
        void execute(EntityManager em);
    }
}