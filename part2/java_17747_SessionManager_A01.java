import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_17747_SessionManager_A01 implements HttpSessionListener {

    private static final String PERSISTENCE_UNIT_NAME = "MyPersistenceUnit";
    private EntityManagerFactory emf;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        se.getSession().setAttribute("entityManager", em);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        EntityManager em = (EntityManager) se.getSession().getAttribute("entityManager");
        em.close();
        emf.close();
    }

}

class MySession extends HttpSession {

    private EntityManager em;

    @Override
    public void setAttribute(String name, Object value) {
        super.setAttribute(name, value);
        if (name.equals("entityManager")) {
            em = (EntityManager) value;
        }
    }

    public void performDbOperation(String jpql) {
        em.createQuery(jpql).getSingleResult();
    }
}