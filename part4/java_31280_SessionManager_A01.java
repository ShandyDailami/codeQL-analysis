import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class java_31280_SessionManager_A01 {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("test");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public static void main(String[] args) {
        runBrokenAccessControlExample();
    }

    private static void runBrokenAccessControlExample() {
        // Broken Access Control
        try {
            // Open Session
            entityManager.getTransaction().begin();

            // Create a query to search for a user by their ID
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
            Root<User> root = criteriaQuery.from(User.class);

            // This is a hack, but there is no way around it
            criteriaQuery.select(root);

            // Start transaction
            entityManager.getTransaction().begin();

            // This should fail because the session is open and we are not managing the transaction
            User user = entityManager.find(User.class, 1);

            // End transaction
            entityManager.getTransaction().commit();

            // Print the user's information
            System.out.println("User Information: " + user.toString());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close Session
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}