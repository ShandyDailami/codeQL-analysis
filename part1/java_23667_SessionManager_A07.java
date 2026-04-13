import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class java_23667_SessionManager_A07 {
    public static void main(String[] args) {
        // Step 1: Create the entity manager factory
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example");

        // Step 2: Open a session
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        // Step 3: Perform some operation
        // In this case, we're just retrieving a user with a given ID
        User user = entityManager.find(User.class, 1);

        // Step 4: Close the session
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}

class User {
    private int id;
    // other fields

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}