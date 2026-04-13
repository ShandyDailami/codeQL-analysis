import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class java_05933_SessionManager_A03 {

    private EntityManagerFactory entityManagerFactory;

    public java_05933_SessionManager_A03() {
        entityManagerFactory = Persistence.createEntityManagerFactory("my_persistence_unit");
    }

    public void openSession(String userId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Session session = entityManager.unwrap(Session.class);
        User user = session.get(User.class, userId);

        if (user == null) {
            System.out.println("User not found");
        } else {
            System.out.println("User found: " + user);
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static void main(String[] args) {
        SecureSessionManager sessionManager = new SecureSessionManager();
        sessionManager.openSession("123");
    }
}