import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class java_07299_SessionManager_A01 {
    private EntityManagerFactory emf;

    public java_07299_SessionManager_A01() {
        emf = Persistence.createEntityManagerFactory("jpa_unit");
    }

    public void openSession(String entityName) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        String jpql = "FROM " + entityName;
        Query query = em.createQuery(jpql);

        // This is a SELECT operation, we don't need to do anything with the result.
        query.getResultList();

        em.getTransaction().commit();
        em.close();
    }

    public void closeSession(String entityName) {
        // Here, we can do nothing because we are not doing any insert, update or delete operation.
    }
}