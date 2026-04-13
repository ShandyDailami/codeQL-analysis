import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public class java_06784_SessionManager_A07 {
    
    @PersistenceContext(unitName = "authUnit")
    private EntityManager entityManager;
    
    private Optional<EntityManager> manager;

    public java_06784_SessionManager_A07() {
        this.manager = Optional.of(Persistence.createEntityManagerFactory("authUnit").createEntityManager());
    }

    public Optional<User> getUser(String username) {
        return manager.map(em -> em.find(User.class, username));
    }

    public void addUser(User user) {
        manager.map(em -> {
            em.persist(user);
            return user;
        });
    }
    
    public void closeSession() {
        manager.ifPresent(EntityManager::close);
    }
}