import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class java_08710_SessionManager_A03 {
    // Create an instance of EntityManagerFactory
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public java_08710_SessionManager_A03() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("EmployeePU");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public void openSession() {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
    }

    public void closeSession() {
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void save(Object object) {
        entityManager.persist(object);
    }

    public <T> T find(Class<T> clazz, Object id) {
        return entityManager.find(clazz, id);
    }

    public <T> void delete(T object) {
        entityManager.remove(object);
    }

    public <T, U> List<U> findWithCriteria(Class<T> clazz, String criteria) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<U> criteriaQuery = criteriaBuilder.createQuery(clazz);
        Root<U> root = criteriaQuery.from(clazz);

        // Replace the "criteria" parameter with your actual criteria
        criteriaQuery.where(criteriaBuilder.like(root, criteria));

        List<U> result = entityManager.createQuery(criteriaQuery).getResultList();

        return result;
    }
}