import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class java_28438_SessionManager_A03 {
    private EntityManagerFactory entityManagerFactory;

    public java_28438_SessionManager_A03() {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpa_unit");
    }

    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    public void closeEntityManager() {
        entityManagerFactory.close();
    }
}