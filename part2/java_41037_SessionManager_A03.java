import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class java_41037_SessionManager_A03 {

    @PersistenceContext
    private EntityManager entityManager;

    public List<String> getAllUserNames() {
        TypedQuery<String> query = entityManager.createQuery("SELECT u.name FROM User u", String.class);
        return query.getResultList();
    }

    public void saveUser(User user) {
        entityManager.persist(user);
    }

    public void updateUser(User user) {
        entityManager.merge(user);
    }

    public void deleteUser(String name) {
        User user = entityManager.find(User.class, name);
        entityManager.remove(user);
    }
}