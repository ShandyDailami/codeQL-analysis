import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class java_06642_SessionManager_A08 {

    private EntityManagerFactory entityManagerFactory;

    public java_06642_SessionManager_A08() {
        entityManagerFactory = Persistence.createEntityManagerFactory("JPAPU");
    }

    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    public void closeEntityManager(EntityManager entityManager) {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
    }

    public void closeEntityManagerFactory() {
        if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
            entityManagerFactory.close();
        }
    }

    public void persist(Object entity) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        closeEntityManager(entityManager);
    }

    public <T> T find(Class<T> clazz, Object id) {
        EntityManager entityManager = getEntityManager();
        T entity = entityManager.find(clazz, id);
        closeEntityManager(entityManager);
        return entity;
    }

    public void delete(Object entity) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
        closeEntityManager(entityManager);
    }
}