import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class java_04545_SessionManager_A01 {

    @Id
    private String sessionId;

    // required default constructor for JPA
    public java_04545_SessionManager_A01() {
    }

    public java_04545_SessionManager_A01(String sessionId) {
        this.sessionId = sessionId;
    }

    // getters and setters omitted for brevity
}

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public class SessionManager {

    private EntityManagerFactory emf;

    @PersistenceContext
    private EntityManager em;

    public java_04545_SessionManager_A01() {
        emf = Persistence.createEntityManagerFactory("myPU");
    }

    public void startSession(String sessionId) {
        em.getTransaction().begin();
        em.persist(new SecureSession(sessionId));
        em.getTransaction().commit();
    }

    public SecureSession getSession(String sessionId) {
        return em.find(SecureSession.class, sessionId);
    }

    public void endSession(String sessionId) {
        em.getTransaction().begin();
        SecureSession secureSession = em.find(SecureSession.class, sessionId);
        em.remove(secureSession);
        em.getTransaction().commit();
    }

    public void close() {
        emf.close();
    }
}