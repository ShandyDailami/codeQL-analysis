import javax.persistence.*;

public class java_27512_SessionManager_A08 {
    private static EntityManager entityManager;

    public static void main(String[] args) {
        // Create SessionFactory
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistenceUnit");
        entityManager = entityManagerFactory.createEntityManager();

        // Start the session
        Session session = entityManager.unwrap(Session.class);

        // Begin transaction
        Session newSession = entityManager.unwrap(Session.class);
        Transaction transaction = newSession.beginTransaction();

        // Start the integrity failure operation
        System.out.println("Starting integrity failure operation...");

        // Trying to insert a null entity
        try {
            User user = null;
            session.save(user);
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            System.out.println("An integrity failure occurred when attempting to save a null user entity.");
        }

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Entity
    @Table(name = "users")
    public static class User {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        private String name;

        // Getters and setters
    }
}