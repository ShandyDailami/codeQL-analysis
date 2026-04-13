import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class java_09787_SessionManager_A01 {
    private EntityManager entityManager;

    public java_09787_SessionManager_A01() {
        entityManager = Persistence.createEntityManagerFactory("my_persistence_unit").createEntityManager();
    }

    public void persist(Object entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    public <T> T find(Class<T> clazz, Object id) {
        return entityManager.find(clazz, id);
    }

    public <T> T executeQuery(String query, Object[] params) {
        Query q = entityManager.createQuery(query);
        for (int i = 0; i < params.length; i++) {
            q.setParameter(i, params[i]);
        }
        return (T) q.getSingleResult();
    }

    public void close() {
        entityManager.close();
    }
}