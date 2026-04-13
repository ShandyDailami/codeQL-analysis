import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class java_40877_SessionManager_A07 {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("my_persistence_unit");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        // Execute SQL query
        entityManager.createNativeQuery("SELECT * FROM USERS").executeUpdate();

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}