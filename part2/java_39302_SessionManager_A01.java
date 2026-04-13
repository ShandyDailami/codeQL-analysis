import javax.persistence.*;

public class java_39302_SessionManager_A01 {

    @Entity
    @Table(name = "users")
    public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String username;

        private String password;

        // getters and setters
    }

    private EntityManager entityManager;

    public java_39302_SessionManager_A01() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("userPersistenceUnit");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public User getUser(Long id) {
        return entityManager.find(User.class, id);
    }

    public void closeEntityManager() {
        entityManager.close();
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        User user = sessionManager.getUser(1L);
        sessionManager.closeEntityManager();
    }
}