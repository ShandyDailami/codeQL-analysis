import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class java_38209_SessionManager_A03 {
    private EntityManagerFactory emf;
    private EntityManager em;

    public java_38209_SessionManager_A03() {
        emf = Persistence.createEntityManagerFactory("persistenceUnit");
        em = emf.createEntityManager();
    }

    public void beginTransaction() {
        em.getTransaction().begin();
    }

    public void commit() {
        em.getTransaction().commit();
    }

    public void close() {
        em.close();
        emf.close();
    }

    public Object executeQuery(String queryString) {
        Query query = em.createQuery(queryString);
        return query.getResultList();
    }
}