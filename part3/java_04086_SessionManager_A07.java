import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

public class java_04086_SessionManager_A07 {
    private static EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("JPATest");
    }

    public static void main(String[] args) {
        runOperation();
        emf.close();
    }

    private static void runOperation() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // Assume we have a User entity and a Session entity
        User user = em.find(User.class, 1); // Replace with actual user
        Session session = em.find(Session.class, 1); // Replace with actual session

        // Check if session has expired
        if (session.getLastUsed().before(getOneYearAgo())) {
            // Session has expired. Invalidate it and create a new one.
            session.setValid(false);
            session = new Session();
            session.setUser(user);
            session.setLastUsed(new Date());
            user.getSessions().add(session);

            em.persist(session);
            em.persist(user);
        }

        // Commit the transaction
        em.getTransaction().commit();
        em.close();
    }

    // Assume we have a User entity and a Session entity
    private static class User {
        // Other fields...

        private java.util.List<Session> sessions = new java.util.ArrayList<>();
    }

    private static class Session {
        // Other fields...

        private User user;
        private java.util.Date lastUsed;
    }

    private static java.util.Date getOneYearAgo() {
        return new java.util.Date(new java.util.Date().getTime() - 31556000000L);
    }
}