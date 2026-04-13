import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.security.auth.Subject;

public class java_33621_SessionManager_A01 {
    private EntityManagerFactory emf;

    public java_33621_SessionManager_A01() {
        emf = Persistence.createEntityManagerFactory("examplePU");
    }

    public void openSession(Subject subject) {
        emf.getPersistenceUnitUtil().beginTransaction();
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void closeSession(EntityManager em) {
        em.getTransaction().commit();
        emf.getPersistenceUnitUtil().endTransaction();
    }

    public void closeEntityManager(EntityManager em) {
        em.close();
    }
}