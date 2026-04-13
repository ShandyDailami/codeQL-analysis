import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transaction;
import javax.transaction.Transactional;

public class java_02119_SessionManager_A01 {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private Transaction transaction;

    public java_02119_SessionManager_A01() {
        entityManagerFactory = Persistence.createEntityManagerFactory("example");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Transactional
    public void openSession() {
        transaction = entityManager.getTransaction();
        transaction.begin();
    }

    public void closeSession() {
        if (transaction != null && transaction.isActive()) {
            transaction.commit();
        }
    }

    public void persist(Object entity) {
        entityManager.persist(entity);
    }

    public void merge(Object entity) {
        entityManager.merge(entity);
    }

    public void remove(Object entity) {
        entityManager.remove(entity);
    }

    public Object find(Class clazz, Object primaryKey) {
        return entityManager.find(clazz, primaryKey);
    }

    public void closeEntityManager() {
        entityManager.close();
    }
}