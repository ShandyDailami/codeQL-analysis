import javax.persistence.*;
import java.util.List;

public class java_00925_SessionManager_A08 {
    private EntityManager entityManager;

    public java_00925_SessionManager_A08() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa_persistence_unit");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public void openSession() {
        this.entityManager.getTransaction().begin();
    }

    public void closeSession() {
        if (this.entityManager.getTransaction().isActive()) {
            this.entityManager.getTransaction().commit();
        }
        this.entityManager.close();
    }

    public <T> T find(Class<T> clazz, Object id) {
        return this.entityManager.find(clazz, id);
    }

    public <T> List<T> findAll(Class<T> clazz) {
        Query query = this.entityManager.createQuery("FROM " + clazz.getName());
        return query.getResultList();
    }

    public <T> void persist(T entity) {
        this.entityManager.persist(entity);
    }

    public <T> void update(T entity) {
        this.entityManager.merge(entity);
    }

    public <T> void delete(T entity) {
        this.entityManager.remove(entity);
    }
}