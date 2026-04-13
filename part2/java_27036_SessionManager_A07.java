import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class java_27036_SessionManager_A07 {
    private EntityManagerFactory entityManagerFactory;

    public java_27036_SessionManager_A07() {
        entityManagerFactory = Persistence.createEntityManagerFactory("example");
    }

    public void addSession(Session session) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(session);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<Session> getSessions() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Session> criteriaQuery = criteriaBuilder.createQuery(Session.class);
        Root<Session> root = criteriaQuery.from(Session.class);
        List<Session> sessions = entityManager.createQuery(criteriaQuery).getResultList();
        entityManager.close();
        return sessions;
    }
}