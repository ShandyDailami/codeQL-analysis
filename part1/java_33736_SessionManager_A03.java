import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.security.auth.Subject;

public class java_33736_SessionManager_A03 {
    private Subject currentSessionSubject = null;
    private EntityManagerFactory emf;

    public java_33736_SessionManager_A03() {
        emf = Persistence.createEntityManagerFactory("MyPersistenceUnit");
    }

    public void openSession(Subject subject) {
        currentSessionSubject = subject;
        emf.getPersistenceUnitUtil().setSecurityIdentityInfo(currentSessionSubject);
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
    }

    public void closeSession() {
        if (currentSessionSubject != null) {
            emf.getPersistenceUnitUtil().setSecurityIdentityInfo(null);
            currentSessionSubject = null;
            emf.close();
        }
    }

    public void execute(String query) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createQuery(query).executeUpdate();
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public static void main(String[] args) {
        SecureSessionManager manager = new SecureSessionManager();
        manager.openSession(null);
        manager.execute("SELECT * FROM User WHERE id = :id");
        manager.closeSession();
    }
}