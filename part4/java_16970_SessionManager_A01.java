import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transaction;
import javax.transaction.Transactional;

public class java_16970_SessionManager_A01 {
    private EntityManagerFactory entityManagerFactory;
    private Transaction transaction;

    public java_16970_SessionManager_A01() {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
        transaction = entityManagerFactory.getTransaction();
    }

    @Transactional
    public void performOperation() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            // perform security-sensitive operations here

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            // handle exceptions here
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }
}