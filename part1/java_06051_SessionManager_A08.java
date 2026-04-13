import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class java_06051_SessionManager_A08 {
    private static EntityManagerFactory emf;

    // Lazy initialization
    private static EntityManager em;

    // Singleton pattern
    public static EntityManager getEntityManager() {
        if (em == null) {
            emf = Persistence.createEntityManagerFactory("jpaExample");
            em = emf.createEntityManager();
        }
        return em;
    }

    public static void main(String[] args) {
        // Use session
        EntityManager em = getEntityManager();
        em.getTransaction().begin();

        // Inserting a new entity
        Person person = new Person();
        person.setName("John");
        person.setEmail("john@example.com");
        em.persist(person);

        // Retrieving an entity
        person = em.find(Person.class, person.getId());
        System.out.println("Name: " + person.getName());
        System.out.println("Email: " + person.getEmail());

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}