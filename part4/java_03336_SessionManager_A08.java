import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.NoResultException;
import javax.transaction.Transaction;
import javax.transaction.Transactional;

public class java_03336_SessionManager_A08 {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("example");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        try {
            User user = em.find(User.class, 1);
            if (user != null && !user.getPassword().equals("correctpassword")) {
                throw new NoResultException();
            }
            em.getTransaction().commit();
        } catch (NoResultException ex) {
            em.getTransaction().rollback();
            System.out.println("Incorrect password");
        }
        em.close();
    }

    // User class
    public static class User {
        private String password;

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}