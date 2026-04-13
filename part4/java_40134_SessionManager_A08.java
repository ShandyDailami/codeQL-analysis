import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class java_40134_SessionManager_A08 {
    private EntityManagerFactory entityManagerFactory;

    public java_40134_SessionManager_A08() {
        entityManagerFactory = Persistence.createEntityManagerFactory("JPAPU");
    }

    public void openSession(Runnable task) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        task.run();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public <T> T find(Class<T> clazz, Object id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        T object = entityManager.find(clazz, id);
        entityManager.close();
        return object;
    }

    public <T> List<T> findAll(Class<T> clazz) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<T> list = entityManager.createQuery("FROM " + clazz.getName(), clazz).getResultList();
        entityManager.close();
        return list;
    }

    public <T> void save(T object) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(object);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public <T> void update(T object) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(object);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public <T> void delete(T object) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(object);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}