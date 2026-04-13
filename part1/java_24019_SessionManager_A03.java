import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class java_24019_SessionManager_A03 {
    public static void main(String[] args) {
        // Step 1: Create EntityManagerFactory
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPAExample");

        // Step 2: Get EntityManager
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Step 3: Create UserDAO
        UserDAO userDAO = new UserDAO(entityManager);

        // Step 4: Create User and insert into database
        User user = new User();
        user.setName("User1");
        userDAO.save(user);

        // Step 5: Close EntityManager
        entityManager.close();
        entityManagerFactory.close();
    }
}

class UserDAO {
    private EntityManager entityManager;

    public java_24019_SessionManager_A03(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(User user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }
}

class User {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}