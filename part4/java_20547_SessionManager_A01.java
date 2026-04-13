import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class java_20547_SessionManager_A01 {

    private EntityManagerFactory entityManagerFactory;

    public java_20547_SessionManager_A01() {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpa-example");
    }

    public void startSession(User user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Optional<UserEntity> userEntity = entityManager.find(UserEntity.class, user.getId());

        if (userEntity.isPresent()) {
            entityManager.getTransaction().commit();
            entityManager.close();
        } else {
            System.out.println("User not found!");
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        User user = new User(1, "John Doe");
        sessionManager.startSession(user);
    }
}

class UserEntity {
    private int id;
    private String name;

    public java_20547_SessionManager_A01(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters and setters
}

class User {
    private int id;
    private String name;

    public java_20547_SessionManager_A01(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}