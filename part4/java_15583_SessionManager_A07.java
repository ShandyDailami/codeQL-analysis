import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class java_15583_SessionManager_A07 {
    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("JPAPersistenceUnit");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // Perform some operations here

        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    public static Optional<EntityManager> getEntityManager() {
        if (emf == null) {
            return Optional.empty();
        }

        EntityManager em = emf.createEntityManager();
        return Optional.of(em);
    }
}