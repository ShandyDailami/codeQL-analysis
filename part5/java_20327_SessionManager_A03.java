import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class java_20327_SessionManager_A03 {
    private EntityManagerFactory emf;

    public java_20327_SessionManager_A03() {
        emf = Persistence.createEntityManagerFactory("jpa");
    }

    public void openSession() {
        emf.getTransaction().begin();
    }

    public void closeSession() {
        emf.getTransaction().commit();
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void persist(Object object) {
        EntityManager em = getEntityManager();
        em.persist(object);
        em.close();
    }

    public static void main(String[] args) {
        SecureSessionManager sessionManager = new SecureSessionManager();
        sessionManager.openSession();

        // Example of security-sensitive operation
        sessionManager.persist(new User("hacker"));

        sessionManager.closeSession();
    }
}