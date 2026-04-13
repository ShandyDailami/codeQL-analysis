import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class java_08303_SessionManager_A03 {

    private EntityManagerFactory entityManagerFactory;

    public java_08303_SessionManager_A03() {
        entityManagerFactory = Persistence.createEntityManagerFactory("my_persistence_unit");
    }

    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    public void closeEntityManager(EntityManager entityManager) {
        if (entityManager != null) {
            entityManager.close();
        }
    }

    public void persist(Object object) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(object);
        entityManager.getTransaction().commit();
        closeEntityManager(entityManager);
    }
}