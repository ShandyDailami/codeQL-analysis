import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateful
public class java_41180_SessionManager_A01 implements java.io.Serializable {
    
    @PersistenceContext(name="myPersistenceUnit")
    private EntityManager em;

    private ThreadLocal<Session> sessionHolder;
    
    public java_41180_SessionManager_A01() {
        sessionHolder = new ThreadLocal<Session>();
    }

    public Session currentSession() {
        Session session = sessionHolder.get();
        if (session == null) {
            session = em.unwrap(Session.class);
            sessionHolder.set(session);
        }
        return session;
    }

    public void closeSession() {
        Session session = sessionHolder.get();
        if (session != null) {
            sessionHolder.set(null);
            session.close();
        }
    }
}