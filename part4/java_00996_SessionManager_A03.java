import javax.ejb.AccessTimeout;
import javax.ejb.State;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@AccessTimeout(value = 5)
public class java_00996_SessionManager_A03 {

    @PersistenceContext(unitName = "MyPersistenceUnit")
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void startSession() {
        // No code here, just demonstrate the start of a session
    }

    public void endSession() {
        // No code here, just demonstrate the end of a session
    }
}