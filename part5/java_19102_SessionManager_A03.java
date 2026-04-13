import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class java_19102_SessionManager_A03 {

    private EntityManagerFactory entityManagerFactory;

    public java_19102_SessionManager_A03() {
        entityManagerFactory = Persistence.createEntityManagerFactory("persistenceUnit");
    }

    public void openSession() {
        entityManagerFactory.createEntityManager();
    }

    public void closeSession() {
        entityManagerFactory.close();
    }

    public void save(Object entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void delete(Object entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void update(Object entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Object find(Class cls, Object primaryKey) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(cls, primaryKey);
    }

    public List<Object> findAll(Class cls) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
        Root<Object> root = criteriaQuery.from(cls);
        criteriaQuery.select(root);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}