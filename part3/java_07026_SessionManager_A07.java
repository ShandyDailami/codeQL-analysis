import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class java_07026_SessionManager_A07 {
    private EntityManagerFactory emf;

    public java_07026_SessionManager_A07() {
        emf = Persistence.createEntityManagerFactory("yourPersistenceUnit");
    }

    public void createSession(HttpServletRequest request, HttpServletResponse response, String userId) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        User user = em.find(User.class, userId);

        if (user == null) {
            System.out.println("User not found!");
            em.getTransaction().rollback();
            return;
        }

        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        em.getTransaction().commit();
        em.close();
    }

    public void closeSession(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.invalidate();
    }
}