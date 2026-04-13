import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

public class java_13641_SessionManager_A08 {

    @PersistenceContext
    private EntityManager entityManager;

    public Optional<User> getUserById(int id) {
        // Step 1: Validate the id
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid user id: " + id);
        }

        // Step 2: Retrieve the user from the database
        User user = entityManager.find(User.class, id);

        // Step 3: Validate the user
        if (user == null) {
            throw new SecurityException("User with id " + id + " not found");
        }

        // Step 4: Return the user
        return Optional.of(user);
    }

    public void updateUserPassword(int id, String newPassword) {
        // Step 1: Validate the id and new password
        if (id <= 0 || newPassword == null || newPassword.length() <= 0) {
            throw new IllegalArgumentException("Invalid user id or empty password");
        }

        // Step 2: Retrieve the user from the database
        User user = entityManager.find(User.class, id);

        // Step 3: Validate the user
        if (user == null) {
            throw new SecurityException("User with id " + id + " not found");
        }

        // Step 4: Update the user's password
        user.setPassword(newPassword);
        entityManager.merge(user);
    }
}