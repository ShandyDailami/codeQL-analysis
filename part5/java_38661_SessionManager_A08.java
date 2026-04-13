import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public class java_38661_SessionManager_A08 {
    private static EntityManagerFactory emf;

    static {
        // Create the entity manager factory
        emf = Persistence.createEntityManagerFactory("jpa_persistence");
    }

    public static void main(String[] args) {
        // Open a session
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // Create a new entity
        Person person = new Person();
        person.setName("John Doe");
        person.setEmail("john@example.com");

        // Save the entity to the database
        em.persist(person);

        // Commit the transaction
        em.getTransaction().commit();

        // Close the entity manager
        em.close();
    }

    // Entity class
    public static class Person {
        private String name;
        private String email;

        // Getters and setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}