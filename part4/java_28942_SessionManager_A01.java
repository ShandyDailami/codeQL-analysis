import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class java_28942_SessionManager_A01 {
    @PersistenceContext
    private EntityManager entityManager;

    private static final String PERSISTENCE_UNIT_NAME = "myPersistenceUnit";

    private java_28942_SessionManager_A01() {
        // Private constructor to prevent instantiation
    }

    private static class Holder {
        private static final SessionManager INSTANCE = new SessionManager();
    }

    public static SessionManager getInstance() {
        return Holder.INSTANCE;
    }

    public Optional<User> getLoggedInUser(String sessionId) {
        // Implementation of loading user from sessionId
        // This is a placeholder and won't work in a real application.
        // It would retrieve a user object from a database or a cache.
        return Optional.empty();
    }

    public void accessProtectedData(String sessionId) {
        Optional<User> user = getLoggedInUser(sessionId);
        if (user.isPresent()) {
            // User is logged in, they can access protected data
            // This is a placeholder and won't work in a real application.
            // It would access a protected data object from a database or a cache.
            System.out.println("User is accessing protected data.");
        } else {
            // User is not logged in, access is not permitted
            System.out.println("User is not logged in. Access is not permitted.");
        }
    }
}