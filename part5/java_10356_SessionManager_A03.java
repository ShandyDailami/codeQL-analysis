import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class java_10356_SessionManager_A03 {

    private EntityManagerFactory factory;

    public java_10356_SessionManager_A03() {
        factory = Persistence.createEntityManagerFactory("example");
    }

    public void openSession(Runnable work) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        work.run();
        em.getTransaction().commit();
        em.close();
    }

    public <T> Optional<T> load(Class<T> type, Long id) {
        EntityManager em = factory.createEntityManager();
        T obj = em.find(type, id);
        em.close();
        return Optional.ofNullable(obj);
    }

    public <T> void persist(T obj) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
        em.close();
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();
        sm.openSession(() -> {
            User user = new User();
            user.setName("John Doe");
            sm.persist(user);
        });

        sm.load(User.class, 1L).ifPresent(user -> System.out.println(user.getName()));
    }

}

class User {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}