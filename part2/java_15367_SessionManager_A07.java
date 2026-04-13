import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@Stateful
public class java_15367_SessionManager_A07 implements SecureSessionManagerLocal, SecureSessionManagerRemote {

    @PersistenceContext(unitName = "MyPersistenceUnit")
    private EntityManager entityManager;

    private String currentSessionId;

    @Override
    public String startSession(String userName) {
        // Check if user is already logged in
        if (currentSessionId != null) {
            throw new IllegalStateException("User already logged in.");
        }

        // Create and persist a new Session
        Session session = new Session();
        session.setUser(new User(userName));
        entityManager.persist(session);

        // Set current session id
        currentSessionId = session.getId();

        return currentSessionId;
    }

    @Override
    public void endSession() {
        // Check if session is currently active
        if (currentSessionId == null) {
            throw new IllegalStateException("No active session found.");
        }

        // Remove the session from the database
        Session session = entityManager.find(Session.class, currentSessionId);
        entityManager.remove(session);

        // Reset current session id
        currentSessionId = null;
    }

    @Override
    public User getLoggedInUser() {
        // Check if session is currently active
        if (currentSessionId == null) {
            throw new IllegalStateException("No active session found.");
        }

        // Get the user from the session
        Session session = entityManager.find(Session.class, currentSessionId);
        return session.getUser();
    }
}

@Stateful
interface SecureSessionManagerLocal {
    String startSession(String userName);
    void endSession();
}

interface SecureSessionManagerRemote {
    User getLoggedInUser();
}