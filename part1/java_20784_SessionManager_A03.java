import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class java_20784_SessionManager_A03 {

    private EntityManagerFactory entityManagerFactory;

    public java_20784_SessionManager_A03() {
        entityManagerFactory = Persistence.createEntityManagerFactory("myPU");
    }

    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    public void closeEntityManager() {
        entityManagerFactory.close();
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        try (EntityManager entityManager = sessionManager.getEntityManager()) {
            entityManager.getTransaction().begin();

            // Here you can write your operations related to security-sensitive operations
            // For example, insert, update, delete operations on a database table

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionManager.closeEntityManager();
        }
    }
}