import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class java_15026_SessionManager_A03 {

    private EntityManagerFactory entityManagerFactory;

    public java_15026_SessionManager_A03() {
        entityManagerFactory = Persistence.createEntityManagerFactory("persistenceUnit");
    }

    public void startSession(Runnable operation) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        operation.run();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public <T> T find(Class<T> entityClass, Object id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        T entity = entityManager.find(entityClass, id);
        entityManager.close();
        return entity;
    }

    public <T> void save(T entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public <T> void delete(T entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public <T> List<T> findAll(Class<T> entityClass) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(entityClass);
        Root<T> root = criteriaQuery.from(entityClass);
        List<T> list = entityManager.createQuery(criteriaQuery).getResultList();
        entityManager.close();
        return list;
    }
}