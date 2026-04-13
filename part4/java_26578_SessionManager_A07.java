import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.security.AccessControlAction;
import java.security.AccessControlListener;
import java.security.Guard;
import java.security.PrivilegedAction;
import java.util.HashSet;
import java.util.Set;

public class java_26578_SessionManager_A07 {
    private static class MySubject implements Subject {
        public <T> T doPrivileged(PrivilegedAction<T> action) {
            return action.execute();
        }

        public Set<Guard> getGuards() {
            return new HashSet<>();
        }

        public Set<AccessControlListener> getAccessControlListeners() {
            return new HashSet<>();
        }

        public boolean implies(Subject subject) {
            return false;
        }
    }

    private static class MyCallbackHandler implements CallbackHandler {
        public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        }
    }

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_example");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> root = cq.from(User.class);
        cq.select(root);

        User user = new User();
        user.setUsername("test");
        user.setPassword("test");
        em.persist(user);

        cq.where(cb.equal(root.get("username"), user.getUsername()));
        Set<User> result = (Set<User>) em.createQuery(cq).getResultList();

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}