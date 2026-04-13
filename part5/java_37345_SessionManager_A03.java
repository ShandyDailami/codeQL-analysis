import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class java_37345_SessionManager_A03 {

    // Create a factory for the EntityManager
    private static EntityManagerFactory emf;

    // Singleton instance of the EntityManager
    private static EntityManager em;

    // Private constructor to restrict instantiation of the class
    private java_37345_SessionManager_A03() {}

    // Initialize the Singleton instance of the EntityManager
    static {
        emf = Persistence.createEntityManagerFactory("JPAExample");
        em = emf.createEntityManager();
    }

    // Get the Singleton instance of the EntityManager
    public static EntityManager getEntityManager() {
        return em;
    }

    // Close the EntityManager
    public static void closeEntityManager() {
        em.close();
        emf.close();
    }
}