import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class java_19874_SessionManager_A01 {
    private EntityManagerFactory emf;

    public java_19874_SessionManager_A01() {
        emf = Persistence.createEntityManagerFactory("JPA_PU");
    }

    public void openSession(String entityName) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        System.out.println("Opening session for entity: " + entityName);

        // Start the session here.
        // You can do something like:
        // em.persist(myEntityInstance);

        em.getTransaction().commit();
        em.close();
    }

    public void closeSession(String entityName) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        System.out.println("Closing session for entity: " + entityName);

        // If there are any unsaved changes, you should commit them:
        em.getTransaction().commit();

        em.close();
    }
}