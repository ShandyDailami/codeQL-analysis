import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class java_36880_SessionManager_A08 {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public java_36880_SessionManager_A08() {
        entityManagerFactory = Persistence.createEntityManagerFactory("example");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void openSession(Runnable task) {
        entityManager.getTransaction().begin();
        task.run();
        entityManager.getTransaction().commit();
    }

    public <T> Optional<T> find(Class<T> clazz, long id) {
        return Optional.ofNullable(entityManager.find(clazz, id));
    }

    public <T> T save(T entity) {
        return entityManager.merge(entity);
    }

    public <T> void delete(T entity) {
        entityManager.remove(entity);
    }

    public void close() {
        entityManager.close();
        entityManagerFactory.close();
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.openSession(() -> {
            Person person = sessionManager.find(Person.class, 1).orElseGet(() -> {
                Person newPerson = new Person();
                newPerson.setName("John Doe");
                return sessionManager.save(newPerson);
            });

            person.setName("Jane Doe");
            sessionManager.save(person);

            sessionManager.delete(person);
        });

        sessionManager.close();
    }
}