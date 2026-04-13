import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transaction;
import javax.transaction.Transactional;

public class java_21958_SessionManager_A03 {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-unit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        // Create a new session for unique data
        Session session = entityManager.createSession();

        // Use transaction to add unique data to the session
        addUniqueData(session);

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Transactional
    private static void addUniqueData(Session session) {
        // Add unique data to the session
        session.save(new UniqueData(UUID.randomUUID().toString()));
    }
}

class UniqueData {
    @Id
    private String id;

    public java_21958_SessionManager_A03(String id) {
        this.id = id;
    }

    // Getters and setters are not shown for brevity
}