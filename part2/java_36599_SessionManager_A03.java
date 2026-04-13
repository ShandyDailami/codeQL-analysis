import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class java_36599_SessionManager_A03 {

    private static final String PERSISTENCE_UNIT_NAME = "myPU";
    private static EntityManagerFactory factory;

    // static initialization block
    static {
        try {
            factory = Persistence.createPersistenceUnit(PERSISTENCE_UNIT_NAME, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static EntityManager getEntityManager() {
        return factory.createEntityManager();
    }

    public static void closeEntityManager(EntityManager em) {
        if (em != null) {
            em.close();
        }
    }

    public static void main(String[] args) {
        EntityManager em = getEntityManager();

        // perform some operations on the entity manager

        closeEntityManager(em);
    }
}